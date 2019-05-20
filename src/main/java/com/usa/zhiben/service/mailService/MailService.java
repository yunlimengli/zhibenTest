package com.usa.zhiben.service.mailService;

import com.usa.zhiben.bean.web.mail.InlineResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @author 胖花
 * @create 2019-03-19 14:57
 */
@Service
public class MailService {


    private final static Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String formMail;


    /**
     * 发送一般邮件
     *
     * @param toMail
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String toMail, String subject, String content) {

        sendMail(toMail, subject, content);
    }


    /**
     * 发送HTML 邮件
     *
     * @param toMail
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String toMail, String subject, String content) {
        MimeMessage mimeMessage = sender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setFrom(formMail);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setSubject(subject);
            sender.send(mimeMessage);
            logger.info("发送给" + toMail + "html邮件已经发送。 subject：" + subject);
        } catch (MessagingException e) {
            logger.info("发送给" + toMail + "html send mail error subject：" + subject);
            e.printStackTrace();
        }
    }


    /**
     * 发送静态资源（一般是图片）的邮件
     *
     * @param to
     * @param subject
     * @param content     邮件内容，需要包括一个静态资源的id，比如：<img src=\"cid:image\" >
     * @param resourceist 静态资源list
     */
    public void sendInlineResourceMail(String to, String subject, String content, List<InlineResource> resourceist) {
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(formMail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            for (InlineResource inlineResource : resourceist) {
                FileSystemResource res = new FileSystemResource(new File(inlineResource.getPath()));
                helper.addInline(inlineResource.getCid(), res);
            }
            sender.send(message);
//            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
//            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }


    /**
     * 发送带附件的邮件
     *
     * @param toMail
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String toMail, String subject, String content, String filePath) {
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(formMail);
            helper.setTo(toMail);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf("/"));
            helper.addAttachment(fileName, file);
            sender.send(message);
            logger.info("发送给" + toMail + "带附件的邮件已经发送。");
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("发送给" + toMail + "带附件的邮件时发生异常！", e);
        }
    }

    /**
     * 异步发送邮件
     *
     * @param toMail
     * @param sub
     * @param content
     */
    @Async("asyncZhiben")
    public void sendMailAsync(String toMail, String sub, String content) {
        logger.info("准备开始发送邮件");
        /**
         * 耗时试验
         */
        logger.info("开始耗时等待");
        try {
            Thread.sleep(5000);
            sendMail(toMail, sub, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("耗时等待结束，线程结束");
    }


    /**
     * 发送一般邮件
     *
     * @param toMail  收件人
     * @param sub     标题
     * @param content 内容
     */
    private void sendMail(String toMail, String sub, String content) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(formMail);
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setSubject(sub);
        simpleMailMessage.setText(content);

        try {
            sender.send(simpleMailMessage);
            logger.info("发送给" + toMail + "简单邮件已经发送。 subject：" + sub);
        } catch (Exception e) {
            logger.info("发送给" + toMail + "send mail error subject：" + sub);
            e.printStackTrace();
        }
    }
}
