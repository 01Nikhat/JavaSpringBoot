INSERT INTO patient (name, gender, birth_date, email, blood_group)
VALUES
  ('Nikhat','female','2000-01-01','nik@gmail.com','AB_POSITIVE'),
  ('Naaz','female','2002-01-01','naaz@gmail.com','O_POSITIVE'),
  ('naureen','female','2015-01-01','noorah@gmail.com','AB_POSITIVE'),
  ('Naheed','female','1996-03-07','naheed@gmail.com','B_POSITIVE'),
  ('sam','male','1998-10-01','sam@gmail.com','O_POSITIVE')
ON CONFLICT (email) DO NOTHING;
