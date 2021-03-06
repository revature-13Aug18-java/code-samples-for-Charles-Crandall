package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoInterface;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoInterface;
import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;
public class FunctionalityTest {
	private static Logger log = Logger.getRootLogger();
	@Test
	public void testEmployeeFetchAll() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertEquals(102,ed.getAllEmployees().size());
	}
	
	@Test
	public void testEmployeeFetchManagers() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertEquals(12,ed.getAllManagers().size());
	}	
	
	@Test
	public void testEmployeeFetchNonManagers() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertEquals(90,ed.getNonManagers().size());
	}
	
	@Test
	public void testEmployeeFetchOneEmployee() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertNotEquals(null,ed.getEmployeeById(30));
	}	
	
	@Test
	public void testEmployeeFetchOneEmployeeByUsername() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertNotEquals(null,ed.getEmployeeByUsername("11ccrandall"));
	}
	
	@Test
	public void testEmployeeFetchNullEmployee() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertEquals(null,ed.getEmployeeById(-1));
	}

	@Test
	public void checkRightPassword() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertTrue(ed.matchPassword("11ccrandall", "test"));
	}

	@Test
	public void checkWrongPassword() {
		EmployeeDaoInterface ed = new EmployeeDao();
		assertFalse(ed.matchPassword("11ccrandall", "THIS PASSWORD IS WRONG"));
	}
	
	@Test
	public void testAddRollbackEmp() {
		EmployeeDaoInterface ed = new EmployeeDao();
		Employee emp = new Employee();
		int feedback = ed.addEmployee(emp);
		assertEquals(1,feedback);
	}
	
	@Test
	public void testAddRollbackMan() {
		EmployeeDaoInterface ed = new EmployeeDao();
		Employee emp = new Employee();
		int feedback = ed.addManager(emp);
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdateEmail() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updateEmail("11ccrandall", "TemporaryEmail@doit.nike");
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdateIsManager() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updateIsManager("11ccrandall", false);
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdatePass() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updatePass("11ccrandall", "TemporaryPassword");
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdatePhone() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updatePhone("11ccrandall", 0l);
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdateSecondary() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updateSecond("11ccrandall", 0L);
		assertEquals(1,feedback);
	}
	
	@Test
	public void testUpdateState() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.updateState("11ccrandall", "AL");
		assertEquals(1,feedback);
	}
	
	@Test
	public void testDeleteByEmployee() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.deleteEmployee(ed.getEmployeeById(102));
		assertEquals(1,feedback);
	}
	
	@Test
	public void testDeleteByUsername() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.deleteEmployee("11ccrandall");
		assertEquals(1,feedback);
	}
	
	@Test
	public void testDeleteById() {
		EmployeeDaoInterface ed = new EmployeeDao();
		int feedback = ed.deleteEmployee(102);
		assertEquals(1,feedback);
	}
	
//	@Test
//	@Depricated
//	public void testRequestFetchAll() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(600,rd.getAllRequests().size());
//	}
	
	@Test
	public void testRequestFetchById() {
		RequestDaoInterface rd = new RequestDao();
		assertNotNull(rd.getRequestByID(3));
	}
	
//	@Test
//	public void testRequestFetchByManId() {
//		RequestDaoInterface rd = new RequestDao();
//		assertNotNull(rd.getRequestByManagerId(31));
//	}
	
//	@Test
//	public void testRequestFailByManId() {
//		RequestDaoInterface rd = new RequestDao();
//		assertNull(rd.getRequestByManagerId(300));
//	}
	
	@Test
	public void testRequestAdd() {
		RequestDaoInterface rd = new RequestDao();
		assertEquals(1,rd.addRequest(3,123.0f,"I GOT A THING PLZ"));
	}
//	
//	@Test
//	public void testRequestApprove() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(1,rd.approveRequest(2));
//	}
//	
//	@Test
//	public void testRequestApproveFail() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(0,rd.approveRequest(-3));
//	}
//	
//	@Test
//	public void testRequestAlreadyApproved() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(0,rd.approveRequest(3));
//	}
//	
//	@Test
//	public void testRequestDeny() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(1,rd.approveRequest(2));
//	}
//	
//	@Test
//	public void testRequestDenyFail() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(0,rd.approveRequest(-3));
//	}
//	
//	@Test
//	public void testRequestAlreadyDenied() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(0,rd.approveRequest(3));
//	}
	
//	@Test
//	public void testRequestDelete() {
//		RequestDaoInterface rd = new RequestDao();
//		assertEquals(1, rd.deleteRequest(89));
//	}
//	
}

