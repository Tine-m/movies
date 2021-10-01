package movieapp.repositories;

import movieapp.models.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    public List<Movie> findAllMovies() {
        List<Movie> result = new ArrayList<>();
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM movies";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(new Movie(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Movie findMovieByTitle(String title) {
        Movie result = null;
        Connection conn = DBManager.getConnection();
        String SQL = "SELECT * FROM movies WHERE title = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               result = new Movie(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("year"),
                        rs.getInt("length"),
                        rs.getString("subject"),
                        rs.getInt("popularity"),
                        rs.getString("awards"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
