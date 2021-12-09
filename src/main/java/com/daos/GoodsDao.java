package com.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.beans.Goods;
import com.beans.User;
import com.mysql.cj.Query;
import com.utils.C3P0Utils;

public class GoodsDao {
	
	//@添加商品
	public int addGoods(Goods goods) {
		int i=0;
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "insert into goods values(null,?,?,?,?,?,'0','0')";
		try {
			i = queryRunner.update(conn,sql,goods.getU_id(),goods.getName(),goods.getQuality(),goods.getImg(),goods.getInf());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		C3P0Utils.closeAll(conn);
		return i;
	}
	//@查看商品
	public List<Goods> selectAllGoods(int u_id) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = C3P0Utils.getCon();
		QueryRunner queryRunner=new QueryRunner();
		String sql = "select * from goods where u_id=? and state='0'";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class),u_id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		C3P0Utils.closeAll(conn);
		return list;
	}
	
	//@商品數量（未實現）
	public List<Goods> countGoods(int state){
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = C3P0Utils.getCon();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select count(state) from goods";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class), state);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		C3P0Utils.closeAll(conn);
		return list;
		
	}
	
	//@查詢所有未審核商品
	public List<Goods> sel_AllGoodsNo(){
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = C3P0Utils.getCon();
		QueryRunner queryRunner=new QueryRunner();
		String sql = "select * from goods where review='0'";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		C3P0Utils.closeAll(conn);
		return list;
	}
	
	//@查詢所有審核通過未上架的商品
	public List<Goods> selectAllGoodsNo(int u_id) {
		List<Goods> list = new ArrayList<Goods>();
		QueryRunner queryRunner=new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "select * from goods where review='1' and u_id=? and state='0'";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class), u_id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		C3P0Utils.closeAll(conn);
		// TODO Auto-generated method stub
		return list;
	}
	
	//@審核商品
	public int reviewGoods(int id) {
		int i = 0;
		Connection connection = C3P0Utils.getCon();
		QueryRunner queryRunner=new QueryRunner();
		String sql = "update goods set review='1' where g_id=?";
		try {
			i = queryRunner.update(connection, sql, id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		C3P0Utils.closeAll(connection);
		return i;
				
	}
	//@上架商品
	public int putGoods(int id) {
		int i = 0;
		Connection conn = C3P0Utils.getCon();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update goods set state='1' where g_id=?";
		try {
			i = queryRunner.update(conn, sql, id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		C3P0Utils.closeAll(conn);
		return i;
	}
	//@下架商品
	public int pullGoods(int id) {
		int i = 0;
		Connection conn = C3P0Utils.getCon();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update goods set state='0' where g_id=?";
		try {
			i = queryRunner.update(conn, sql, id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		C3P0Utils.closeAll(conn);
		return i;
	}
	//@查詢所有上架通過商品
	public List<Goods> selectAllGoodsOK(int u_id) {
		List<Goods> list = new ArrayList<Goods>();
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = C3P0Utils.getCon();
		String sql = "select * from goods where review='1' and u_id=? and state='1'";
		try {
			list = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class), u_id);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		C3P0Utils.closeAll(conn);
		return list;
		
	}
	

}
