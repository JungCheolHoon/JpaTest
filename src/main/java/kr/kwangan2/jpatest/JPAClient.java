package kr.kwangan2.jpatest;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// insert query
//			Board board = new Board();
//			board.setTitle("JPA 제목");
//			board.setWirter("관리자");
//			board.setContent("JPA 글 등록 굳");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			em.persist(board);
			
			// find : select one query
//			Board board = em.find(Board.class,1L);
			
			// udate query
//			board.setTitle("수정된 제목");
			
			// remove query
//			em.remove(board);
			
			// createQuery : select list
//			String jpql = " select b from Board b order by b.seq desc ";
//			List<Board> boardList = em.createQuery(jpql,Board.class).getResultList();
//			
//			for(Board brd: boardList) {
//				System.out.println("------>"+ brd.toString());
//			}
			
			// merge
			Board board = em.find(Board.class, 3L);
			em.detach(board);
			board.setContent("머지가 뭐지??");
			em.merge(board);
			
			
//			System.out.println(board);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
