import java.sql.*; import java.util.*;
public class BlogDAO {
    public void add(Blog b){
        try{
            Connection c=DBConnection.getConnection();
            PreparedStatement ps=c.prepareStatement(
            "INSERT INTO blogs(title,content,tags,user_id) VALUES(?,?,?,?)");
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getContent());
            ps.setString(3,b.getTags());
            ps.setInt(4,b.getUserId());
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    public List<Blog> getAll(){
        List<Blog> list=new ArrayList<>();
        try{
            ResultSet rs=DBConnection.getConnection()
            .createStatement().executeQuery("SELECT * FROM blogs ORDER BY created_at DESC");
            while(rs.next()){
                list.add(new Blog(rs.getInt("id"),
                rs.getString("title"),rs.getString("content"),
                rs.getString("tags"),rs.getInt("user_id"),
                rs.getString("created_at")));
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public Blog getById(int id){
        try{
            PreparedStatement ps=DBConnection.getConnection()
            .prepareStatement("SELECT * FROM blogs WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return new Blog(id,rs.getString("title"),
                rs.getString("content"),rs.getString("tags"),
                rs.getInt("user_id"),rs.getString("created_at"));
            }
        }catch(Exception e){e.printStackTrace();}
        return null;
    }

    public void delete(int id,int userId){
        try{
            PreparedStatement ps=DBConnection.getConnection()
            .prepareStatement("DELETE FROM blogs WHERE id=? AND user_id=?");
            ps.setInt(1,id); ps.setInt(2,userId);
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    public void update(Blog b,int id){
        try{
            PreparedStatement ps=DBConnection.getConnection()
            .prepareStatement("UPDATE blogs SET title=?,content=?,tags=? WHERE id=?");
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getContent());
            ps.setString(3,b.getTags());
            ps.setInt(4,id);
            ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
    }

    public List<Blog> search(String q){
        List<Blog> list=new ArrayList<>();
        try{
            PreparedStatement ps=DBConnection.getConnection()
            .prepareStatement("SELECT * FROM blogs WHERE title LIKE ? OR tags LIKE ?");
            ps.setString(1,"%"+q+"%"); ps.setString(2,"%"+q+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Blog(rs.getInt("id"),
                rs.getString("title"),rs.getString("content"),
                rs.getString("tags"),rs.getInt("user_id"),
                rs.getString("created_at")));
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
}