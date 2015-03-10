package com.ppsinfo.rsig;

import java.util.*;
import java.util.Map.Entry;

import javax.activation.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import com.ppsinfo.rsig.jdbc.dao.AlerteRelationDAO;
import com.ppsinfo.rsig.jdbc.dao.UtilisateurDAO;
import com.ppsinfo.rsig.jdbc.model.AlerteRelation;
import com.ppsinfo.rsig.jdbc.model.Utilisateur;

public class Mailer {

	private HashMap<String, Long> dernierMail = new HashMap<String, Long>();
	private HashMap<String, Integer> nombreEchecEnvoi = new HashMap<String, Integer>();
	
//	public HashMap<Utilisateur, String> getMapMailToSend() {
//		
//		// La date du jour
//		HashMap<Utilisateur, String> retour = new HashMap<Utilisateur, String>();
//		long date_actuelle = new Date().getTime();
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		
//		// Récupération de tous les utilisateurs
//		UtilisateurDAO userDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
//		ArrayList<Utilisateur> allUsers = (ArrayList<Utilisateur>) userDAO.selectAll();
//		
//		// On parcours l'ensemble des utilisateurs
//		for(Utilisateur user : allUsers)
//		{
//			String mailUser = user.getEmail();
//			long alert_frequence = user.getAlert_frequence();
//
//			// Si la période est écoulée faut envoyer un mail et qu'il n'y a pas eu plus de 3 échecs
//			if(alert_frequence != -1 && date_actuelle >= dernierMail.get(mailUser) + alert_frequence && nombreEchecEnvoi.get(mailUser) < 4)
//			{
//				// On trouve toutes les alertes de l'utilisateur
//				AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
//				ArrayList<AlerteRelation> allAlertesUser = (ArrayList<AlerteRelation>) alerteDAO.selectWhere("id_utilisateur=" + user.getId());
//				
//				String contenu = "Voici le récapitulatif de vos alertes.\n";
//				// On rédige le contenu du mail
//				for(AlerteRelation alerte : allAlertesUser)
//				{
//					contenu += alerte.toString();
//				}
//				
//				// On range le tout dans ce qui sera retourné
//				retour.put(user, contenu);
//			}
//		}
//		
//		return retour;
//	}
//	
//	// Once every hour, on top of the hour, Mondays to Fridays
//	@Scheduled(cron = * 0 * * * MON-FRI)
//	public void sendMail() {
//		// Informations du mail
//		HashMap<Utilisateur, String> mailToSend = getMapMailToSend();
//		String from = "web@gmail.com";
//		String host = "localhost";
//		
//		// On prépare le serveur
//		Properties properties = System.getProperties();
//		properties.setProperty("mail.smtp.host", host);
//		Session session = Session.getDefaultInstance(properties);
//		
//		for(Entry<Utilisateur, String> entry : mailToSend.entrySet())
//		{
//			String to = entry.getKey().getEmail();
//			String contenu = entry.getValue();
//			
//			try
//			{
//				MimeMessage message = new MimeMessage(session);
//				message.setFrom(new InternetAddress(from));
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//				message.setSubject("[Projet GL - Groupe 3] Récapitulatif des Alertes");
//				message.setText(contenu);
//				
//				// Envoie
//				Transport.send(message);
//				System.out.println("Sent message successfully....");
//				dernierMail.put(to, new Date().getTime());
//				
//			} catch (MessagingException mex)
//			{
//				System.err.println("Erreur lors de l'envoi du message récapitulafit à " + to);
//				if(nombreEchecEnvoi.containsKey(to))
//					nombreEchecEnvoi.put(to, nombreEchecEnvoi.get(to) + 1);
//				else
//					nombreEchecEnvoi.put(to, 1);
//				
//				// S'il y a eu 3 échecs alors on créé une alerte pour l'utilisateur
//				if(nombreEchecEnvoi.get(to) > 3)
//				{
//					// CTX pour AlerteRelationDAO
//					ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//					AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
//					
//					// Créé l'alerte puis on l'insère
//					alerteDAO.insert(new AlerteRelation(0, entry.getKey().getId(), 1, 0, new Date(), "Impossible d'envoyer des mails.", "", "", "Nous avons essayé de vous envoyer 3 maisl sans succès. Veuillez changer votre adresse mail."));
//				}
//			}
//		}
//	}
	
}
