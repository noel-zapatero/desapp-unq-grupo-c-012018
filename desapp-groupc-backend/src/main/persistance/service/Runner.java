//package main.persistance.service;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.function.Supplier;
//
//public class Runner {
//
//  private static final ThreadLocal<Session> CONTEXT = new ThreadLocal<>();
//
//  public static <T> T runInSession(Supplier<T> block) {
//    if (CONTEXT.get() != null) {
//      return block.get();
//    }
//
//    Session session = null;
//    Transaction tx = null;
//
//    try {
//      session = SessionFactoryProvider.getInstance().createSession();
//      tx = session.beginTransaction();
//
//      CONTEXT.set(session);
//
//      T result = block.get();
//
//      tx.commit();
//      return result;
//    } catch (RuntimeException e) {
//      if (tx != null && tx.isActive()) {
//        tx.rollback();
//      }
//      throw e;
//    } finally {
//      if (session != null) {
//        CONTEXT.set(null);
//        session.close();
//      }
//    }
//  }
//
//  public static Session getCurrentSession() {
//    Session session = CONTEXT.get();
//    if (session == null) {
//      throw new RuntimeException("No Session in context");
//    }
//    return session;
//  }
//
//}
