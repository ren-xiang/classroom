package util;

import org.springframework.jdbc.core.JdbcTemplate;

public class insertTime {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        for (int i=1;i<=18;i++){
            for(int j=1;j<6;j++){
                for(int k=0;k<=4;k+=2){
                    String sql="insert into Time values(?,?,?)";
                    jdbcTemplate.update(sql,i,"星期"+j,""+(k+1)+","+(k+2));
                }
            }
        }
    }
}
