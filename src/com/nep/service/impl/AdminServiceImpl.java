package com.nep.service.impl;

import com.nep.service.AdminService;
import com.nep.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
        @Override
        public boolean login(String logincode, String password) {
            String sql = "SELECT COUNT(*) FROM nepm WHERE account = ? AND password = ?";  // Ҫִ�е�sql��䣬��ѯ���

            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {  // ��ȡִ��sql�Ķ��� Prepared statement

                stmt.setString(1, logincode);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;  // ������
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

