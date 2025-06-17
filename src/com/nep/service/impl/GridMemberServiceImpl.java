package com.nep.service.impl;

import com.nep.entity.GridMember;
import com.nep.service.GridMemberService;
import com.nep.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GridMemberServiceImpl implements GridMemberService {

    @Override
    public GridMember login(String loginCode, String password) {
        String sql = "SELECT * FROM nepg WHERE account = ? AND password = ?";//Ҫִ�е�sql���

        try (Connection conn= DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {//��ȡִ��sql�Ķ���PreparedStatement

            stmt.setString(1, loginCode);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {//��������
                if (rs.next()) {
                    GridMember gm = new GridMember();
                    gm.setLoginCode(rs.getString("account"));
                    gm.setRealName(rs.getString("name"));
                    gm.setPassword(rs.getString("password"));
                    gm.setGmTel(rs.getString("phoneNumber"));
                    gm.setState(rs.getString("state"));
                    return gm;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 }
