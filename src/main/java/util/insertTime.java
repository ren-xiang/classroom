package util;

import org.springframework.jdbc.core.JdbcTemplate;

public class insertTime {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        for (int week = 1; week <= 18; week++) {
            for (int weekDay = 1; weekDay < 6; weekDay++) {
                for (int session = 0; session <= 4; session += 2) {
                    String sql = "insert into Time values(?,?,?)";
                    jdbcTemplate.update(sql, week, "星期" + weekDay, "" + (session + 1) + "-" + (session + 2));
                }
            }
        }
    }
}
