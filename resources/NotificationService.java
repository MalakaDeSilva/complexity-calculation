package com.cwapp.mail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cwapp.model.Assignment;
import com.cwapp.model.Course;
import com.cwapp.model.Exam;
import com.cwapp.model.Instructor;
import com.cwapp.model.Student;
import com.cwapp.repository.StudentRepository;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;

	@Autowired
	private StudentRepository studentRepo;

	private List<Student> stdList;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmailExam(Exam exam) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom("cwappbb@gmail.com");
		mail.setSubject("Examination");

		mail.setText("Date : " + exam.getDate() + ".\nTime : " + exam.getTime() + ".\nVenue : " + exam.getVenue());

		stdList = studentRepo.findAll();

		for (Student std : stdList) {
			mail.setTo(std.getEmail());
			javaMailSender.send(mail);
		}
	}

	public void sendEmailAssignment(Assignment assignment) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setFrom("cwappbb@gmail.com");
		mail.setSubject("Examination");

		mail.setText("Assignment : " + assignment.getName() + ".\nDue Date : " + assignment.getDuedate());

		stdList = studentRepo.findAll();

		for (Student std : stdList) {
			mail.setTo(std.getEmail());
			javaMailSender.send(mail);
		}
	}

	public void sendEmailInstructor(Instructor instructor) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("");
		mail.setFrom("cwappbb@gmail.com");
		mail.setSubject("Instructor");

		mail.setText("Test");

		javaMailSender.send(mail);
	}

	public void sendEmailCourse(Course course) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("");
		mail.setFrom("cwappbb@gmail.com");
		mail.setSubject("Course");

		mail.setText("Test");

		javaMailSender.send(mail);
	}

}
