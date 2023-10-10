/* File: ReceiverssDataAccessObjectImplementation.java
 * Author: Zhicheng He
 * Date: 2023/10/10
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.ReceiverDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReceiversDaoImpl implements ReceiversDao {

    @Override
    public void getMetaData() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID, Name,City, Year, Category FROM Receivers ORDER BY AwardID");
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public List<ReceiverDTO> getAllReceivers() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ReceiverDTO> receivers = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID, Name, Category FROM Receivers ORDER BY AwardID");
            rs = pstmt.executeQuery();
            receivers = new ArrayList<ReceiverDTO>();
            while (rs.next()) {
                ReceiverDTO receiver = new ReceiverDTO();
                receiver.setAwardID(rs.getInt("AwardID"));
                receiver.setName(rs.getString("Name"));
                receiver.setCategory(rs.getString("Category"));
                receivers.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return receivers;
    }

    @Override
    public ReceiverDTO getReceiverByReceiverId(Integer awardID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ReceiverDTO receiver = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT AwardID, Name, Category FROM Receivers WHERE AwardID = ?");
            pstmt.setInt(1, awardID.intValue());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                receiver = new ReceiverDTO();
                receiver.setAwardID(rs.getInt("AwardID"));
                receiver.setName(rs.getString("Name"));
                receiver.setCategory(rs.getString("Category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return receiver;
    }

    @Override
    public void addReceiver(ReceiverDTO receiver) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AwardID, it is generated by Database
            pstmt = con.prepareStatement(
                    "INSERT INTO Receivers (Name, Category,Year,City) "
                    + "VALUES(?, ?, ?,?)");
            pstmt.setString(1, receiver.getName());
            pstmt.setString(2, receiver.getCategory());
            pstmt.setInt(3, 0);
            pstmt.setString(4, receiver.getCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updateReceiver(ReceiverDTO receiver) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "UPDATE Receivers SET Name = ?, "
                    + "Category = ? WHERE AwardID = ?");
            pstmt.setString(1, receiver.getName());
            pstmt.setString(2, receiver.getCategory());
            pstmt.setInt(3, receiver.getAwardID().intValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void deleteReceiver(ReceiverDTO receiver) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM Receivers WHERE AwardID = ?");
            pstmt.setInt(1, receiver.getAwardID().intValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
