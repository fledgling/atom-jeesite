/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.CatgDAO;

import com.github.obullxl.jeesite.dal.dto.CatgDTO;
import java.util.List;
import org.springframework.dao.DataAccessException;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.CatgDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Sun Dec 29 10:07:16 CST 2013.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisCatgDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements CatgDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>CatgDTO</tt> object to DB table <tt>atom_catg</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_catg(id,top,catg,sort,name,gmt_create,gmt_modify) values (?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param catg
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(CatgDTO catg) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.insert");
	try {
    	if (catg == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            catg.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-CATG.insert", catg);

        return catg.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Update DB table <tt>atom_catg</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update atom_catg set top=?, catg=?, sort=?, name=?, gmt_modify=? where (id = ?)</tt>
	 *
	 *	@param catg
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(CatgDTO catg) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.update");
	try {
    	if (catg == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return this.getSqlSession().update("ATOM-CATG.update", catg);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_catg</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_catg where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return CatgDTO
	 *	@throws DataAccessException
	 */	 
    public CatgDTO find(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.find");
	try {
        Long param = new Long(id);

        return this.getSqlSession().selectOne("ATOM-CATG.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_catg</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_catg order by sort ASC</tt>
	 *
	 *	@return List<CatgDTO>
	 *	@throws DataAccessException
	 */	 
    public List<CatgDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-CATG.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_catg</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_catg where (name = ?)</tt>
	 *
	 *	@param name
	 *	@return CatgDTO
	 *	@throws DataAccessException
	 */	 
    public CatgDTO findName(String name) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.findName");
	try {

        return this.getSqlSession().selectOne("ATOM-CATG.findName", name);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_catg</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_catg where (catg = 'catg')</tt>
	 *
	 *	@param value
	 *	@return CatgDTO
	 *	@throws DataAccessException
	 */	 
    public CatgDTO findCatg(long value) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.findCatg");
	try {
        Long param = new Long(value);

        return this.getSqlSession().selectOne("ATOM-CATG.findCatg", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_catg</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_catg where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(long id) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.delete");
	try {
        Long param = new Long(id);

        return this.getSqlSession().delete("ATOM-CATG.delete", param);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_catg</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_catg where (id >= 0)</tt>
	 *
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.deleteAll");
	try {

        return this.getSqlSession().delete("ATOM-CATG.deleteAll", null);
	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_catg</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_catg where ((id = 'id') OR (catg = 'id'))</tt>
	 *
	 *	@param value
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteCatg(long value) throws DataAccessException{
	Profiler.enter("DAO: ATOM-CATG.deleteCatg");
	try {
        Long param = new Long(value);

        return this.getSqlSession().delete("ATOM-CATG.deleteCatg", param);
	} finally {
		Profiler.release();
	}
}
}
