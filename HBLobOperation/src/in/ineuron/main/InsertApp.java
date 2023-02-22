package in.ineuron.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		byte[] imageContent = null;
		char[] resumeContent = null;

		try (FileInputStream fis = new FileInputStream("nitin.JPG")) {
			imageContent = new byte[(int) fis.available()];
			fis.read(imageContent);

			File f = new File("resume.txt");
			try (FileReader fr = new FileReader(f)) {
				resumeContent = new char[(int) f.length()];
				fr.read(resumeContent);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();
			JobSeeker seeker = new JobSeeker();
			seeker.setJsName("nitin");
			seeker.setActive(true);
			seeker.setPhoto(imageContent);
			seeker.setResume(resumeContent);

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Integer id = (Integer) session.save(seeker);
				System.out.println("Record saved with the id :: " + id);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("object saved to database...");
			} else {
				transaction.rollback();
				System.out.println("object failed to save...");
			}

			HibernateUtil.closeSession(session);
		}

	}
}
