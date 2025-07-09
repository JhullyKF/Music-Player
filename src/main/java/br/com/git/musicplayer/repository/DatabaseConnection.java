package br.com.git.musicplayer.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String url = "jdbc:h2:./musicplayerdb";
    private static final String user = "sa";
    private static final String password = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void createMusicTable(){
        String sql = "CREATE TABLE IF NOT EXISTS musics (" +
                "id INT AUTO_INCREMENT PRIMATY KEY, " +
                "path VARCHAR(255) NOT NULL, " +
                "title VARCHAR(100) NOT NULL, " +
                "duration INT NOT NULL, " +
                "artist VARCHAR(50) NOT NULL, " +
                "album VARCHAR(50) NOT NULL );";

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()){
                statement.execute(sql);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
