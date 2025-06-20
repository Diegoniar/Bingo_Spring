package com.bingo.bingo.Servicios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class SftpService {
    @Value("${sftp.host}")
    private String host;
    @Value("${sftp.port}")
    private int port;
    @Value("${sftp.user}")
    private String username;
    @Value("${sftp.password}")
    private String password;

    public byte[] descargarArchivo(String rutaRemota){
        Session session = null;
        ChannelSftp channelSftp = null;

        try{
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, port);
            session.setPassword(password);

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            InputStream inputStream = channelSftp.get(rutaRemota);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1 ) {
                outputStream.write(buffer, 0, len);
            }
            return outputStream.toByteArray();
        }catch(JSchException | SftpException | java.io.IOException e){
            throw new RuntimeException("Error al descargar el archivo por STFP: "+ rutaRemota, e);
        }finally {
            if(channelSftp != null){
                channelSftp.disconnect();
            }
            if(session != null){
                session.disconnect();
            }
        }
    }
}
