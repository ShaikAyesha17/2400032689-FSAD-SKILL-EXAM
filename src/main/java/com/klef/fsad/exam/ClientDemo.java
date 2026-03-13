package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ClientDemo
{
 public static void main(String[] args)
 {
  Configuration cfg = new Configuration().configure();

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx = session.beginTransaction();

  // Insert
  Restaurant r = new Restaurant();
  r.setId(1);
  r.setName("ABC Restaurant");
  r.setDate("2026-03-13");
  r.setStatus("Open");

  session.save(r);

  // Update using HQL
  Query q = session.createQuery(
   "update Restaurant set name=:name,status=:status where id=:id");

  q.setParameter("name","XYZ Restaurant");
  q.setParameter("status","Closed");
  q.setParameter("id",1);

  q.executeUpdate();

  tx.commit();

  session.close();
  sf.close();

  System.out.println("Inserted and Updated Successfully");
 }
}