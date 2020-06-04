package com.montojo.carmanag.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseUtil {

    private DataSource dataSource;
    private int counter;

    public DatabaseUtil(DataSource dataSource) {
        counter += 1;
        System.out.println("This is Databaseutil number " + counter);
        this.dataSource = dataSource;
    }


    public List<Owner> getOwners() {
        List<Owner> ownersList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from owner";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                int idCard = resultSet.getInt("id_card");
                int phone = resultSet.getInt("phone");
                String email = resultSet.getString("email");
                Owner ownerTemp = new Owner(id,fullName,idCard,phone,email);
//                System.out.println(ownerTemp.toString());
                ownersList.add(ownerTemp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement, resultSet);
        }

        return ownersList;
    }

    public List<Services> getServices() {
        List<Services> servicesList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from service";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                int carId = resultSet.getInt("car_id");
                String notes = resultSet.getString("notes");
                long price = resultSet.getLong("price");

                Services serviceTemp = new Services(id,name,carId,date,notes,price);
                servicesList.add(serviceTemp);
//                System.out.println(serviceTemp.toString());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement, resultSet);
        }
        return servicesList;
    }

    public List<Car> getCars() {
//        System.out.println("In getCars() of DatabaseUtil");
        List<Car> carsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from car order by owner_id asc";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int ownerId = resultSet.getInt("owner_id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                Car carTemp = new Car(id,ownerId,brand,model);
//                System.out.println(carTemp.toString());
                carsList.add(carTemp);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement, resultSet);
        }
        return carsList;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
        }
    }

    public void saveNewOwner(Owner newOwner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            String sql = "insert into owner (full_name,id_card,phone,email) values (?,?,?,?)";
            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setString(1,newOwner.getFullName());
            preparedStatement.setInt(2,newOwner.getIdCardNumber());
            preparedStatement.setInt(3,newOwner.getPhone());
            preparedStatement.setString(4,newOwner.getEmail());

            preparedStatement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement, null);
        }
    }

    public Owner getOwner(int ownerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Owner retrievedOwner = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from owner where id=?";
            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setInt(1,ownerId);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int id= resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                int idCard = resultSet.getInt("id_card");
                int phone = resultSet.getInt("phone");
                String email = resultSet.getString("email");
                System.out.println("Retrieved Owner. Id: " + id + " Full Name: " + fullName);
                retrievedOwner = new Owner(id,fullName,idCard,phone,email);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement, resultSet);
        }
        return retrievedOwner;
    }

    public void updateOwner(Owner updatedOwner) {

//        int id = updatedOwner.getId();
//        String fullName = updatedOwner.getFullName();
//        int idCard = updatedOwner.getIdCardNumber();
//        int phone = updatedOwner.getPhone();
//        String email = updatedOwner.getEmail();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            String sql = "update  owner set full_name = ?, id_card = ?, phone = ?, email = ? where id = ?";
            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setString(1,updatedOwner.getFullName());
            preparedStatement.setInt(2,updatedOwner.getIdCardNumber());
            preparedStatement.setInt(3,updatedOwner.getPhone());
            preparedStatement.setString(4,updatedOwner.getEmail());
            preparedStatement.setInt(5,updatedOwner.getId());

            preparedStatement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement, null);
        }
    }

    public void deleteOwner(int deleteOwnerId) {

        Connection connection = null;
        PreparedStatement preparedStatementServices = null;
        PreparedStatement preparedStatementCars = null;
        PreparedStatement preparedStatementOwners = null;

        String sqlServices = "delete from service where car_id in (select id from car where owner_id = ?)";
        String sqlCars = "delete from car where owner_id = ?";
        String sqlOwners = "delete from owner where id = ?";

        try {
            connection = dataSource.getConnection();

            preparedStatementServices = connection.prepareStatement(sqlServices);
            preparedStatementCars = connection.prepareStatement(sqlCars);
            preparedStatementOwners = connection.prepareStatement(sqlOwners);

            preparedStatementServices.setInt(1,deleteOwnerId);
            preparedStatementCars.setInt(1,deleteOwnerId);
            preparedStatementOwners.setInt(1,deleteOwnerId);

            preparedStatementServices.execute();
            preparedStatementCars.execute();
            preparedStatementOwners.execute();

            System.out.println("Deleting records on all three tables succeeded!!!");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                preparedStatementServices.close();
                preparedStatementCars.close();
                preparedStatementOwners.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Services> retrieveOwnerServices(int ownerId) {

        ArrayList<Services> servicesList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = dataSource.getConnection();
            String sql = "select * from service where car_id in (select id from car where owner_id = ?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,ownerId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Services tempService = null;

                int serviceId = resultSet.getInt("id");
                String serviceName = resultSet.getString("name");
                String serviceDate = resultSet.getString("date");
                int serviceCarId = resultSet.getInt("car_id");
                String serviceNotes = resultSet.getString("notes");
                Long servicePrice = resultSet.getLong("price");

                tempService = new Services(serviceId,serviceName,serviceCarId,serviceDate,serviceNotes,servicePrice);
                System.out.println(tempService.toString());
                servicesList.add(tempService);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement,resultSet);
        }
        return servicesList;
    }

    public ArrayList<Car> retrieveOwnerCars(int ownerId) {

        ArrayList<Car> carsList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();
            String sql = "select * from car where owner_id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,ownerId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int carId = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                Car carTemp = new Car(carId,ownerId,brand,model);
                System.out.println(carTemp.toString());
                carsList.add(carTemp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement,resultSet);
        }
        return carsList;
    }
}
