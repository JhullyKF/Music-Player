package br.com.git.musicplayer.repository;

import br.com.git.musicplayer.model.entities.Music;

import java.sql.*;
import java.util.ArrayList;

public class InMemoryMusicRepository {
    public InMemoryMusicRepository(){
        DatabaseConnection.createMusicTable();
    }

    public ArrayList<Music> getAllMusics(){
        ArrayList<Music> musics = new ArrayList<>();
        String sql = "SELECT * FROM musics";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql)){
            while(result.next()){
                musics.add(resultSetToMusic(result));
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao listar musicas ", e);
        }
        return musics;
    }

    public Music getMusicById(int id){
        String sql = "SELECT * FROM musics WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try(ResultSet result = preparedStatement.executeQuery()){
                if (result.next()){
                    return resultSetToMusic(result);
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao lista a musica ", e);
        }
        return null;
    }


    public Music getMusicByTitle(String title){
        String sql = "SELECT * FROM musics WHERE title = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, title);
            try(ResultSet result = preparedStatement.executeQuery()){
                if (result.next()){
                    return resultSetToMusic(result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar a musica", e);
        }
        return null;
    }

    private Music resultSetToMusic(ResultSet result) throws SQLException{
        return new Music (
                result.getInt("id"),
                result.getString("path"),
                result.getString("title"),
                result.getString("artist"),
                result.getString("album")
        );
    }

    public boolean addMusic(Music music){
        String sql = "INSERT INTO musics (path, title, artist, album)" +
                "VALUES (?, ?, ?, ?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, music.getPath());
                preparedStatement.setString(2, music.getTitle());
                preparedStatement.setString(3, music.getArtist());
                preparedStatement.setString(4, music.getAlbum());
                preparedStatement.executeUpdate();
                return true;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao adicionar musica na tabela", e);
        }
    }

    public void removeMusicById(int id){
        String sql = "DELETE FROM musics WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0){
                System.out.println("    ▫ Música removida com sucesso.");
            } else {
                System.out.println("    ▫ Erro ao remover música da tabela.");
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao remover música da tabela", e);
        }
    }

    public void removeMusicByTitle(String title){
        String sql = "DELETE FROM musics WHERE title = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, title);
                int affetedRows = preparedStatement.executeUpdate();
                if (affetedRows > 0){
                    System.out.println("    ▫ Música removida com sucesso.");
                } else {
                    System.out.println("    ▫ Erro ao remover música da tabela.");
                }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao remover musica");
        }
    }

    public boolean updateMusic(int id, Music music) {
        String sql = "UPDATE musics SET path = ?, title = ?, artist = ?, album = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, music.getPath());
                preparedStatement.setString(2, music.getTitle());
                preparedStatement.setString(3, music.getArtist());
                preparedStatement.setString(4, music.getAlbum());
                preparedStatement.setInt(5, id);
                preparedStatement.executeUpdate();
                return true;
        } catch (SQLException e){
            throw new RuntimeException("    ▫ Erro ao atualizar tabela.");
        }
    }
}
