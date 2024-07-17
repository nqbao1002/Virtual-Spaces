package com.virtualspaces.controller.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.virtualspaces.constant.Constants;

import com.virtualspaces.model.Fortune;
import com.virtualspaces.model.Sound;
import com.virtualspaces.model.Stats;
import com.virtualspaces.model.UserGoogleDto;
import com.virtualspaces.model.Video;
import com.virtualspaces.model.VideoType;
import com.virtualspaces.model.dao.FortuneDAO;
import com.virtualspaces.model.dao.SoundDAO;
import com.virtualspaces.model.dao.StatsDAO;
import com.virtualspaces.model.dao.UserDAO;
import com.virtualspaces.model.dao.VideoDAO;
import com.virtualspaces.model.dao.VideoTypeDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LoginGoogleHandler"})
public class LoginGoogleHandler extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDto user = getUserInfo(accessToken);
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());
        session.setAttribute("user", user);

        LocalDateTime loginTime = LocalDateTime.now();
        session.setAttribute("loginTime", loginTime);
        LocalDate loginDate = LocalDate.now();

        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPicture(user.getPicture());
        if (user.getEmail().contains("@fpt.edu.vn")) {
            user.setRoleId(1);
        } else {
            user.setRoleId(2);
        }

        VideoTypeDAO type = new VideoTypeDAO();
        List<VideoType> listType = type.returnListType();
        session.setAttribute("typelist", listType);

        FortuneDAO fortuneDAO = new FortuneDAO();
        Fortune fortune = fortuneDAO.getFortune();
        session.setAttribute("fortune", fortune);

        UserDAO userDAO = new UserDAO();
        if (userDAO.find(user.getId()) == null) {
            userDAO.insertUser(user);
        }

        
        
        SoundDAO soundDAO = new SoundDAO();
        List<Sound> sounds = soundDAO.getSoundList();
        session.setAttribute("soundlist", sounds);

        StatsDAO statsDao = new StatsDAO();
        Stats stats = statsDao.check(user.getId());
        if (stats != null) {
//      String dateString = "28/03/2024";
//      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//      LocalDate date = LocalDate.parse(dateString, formatter);
            long daysBetween = ChronoUnit.DAYS.between(stats.getLoginLastest().toLocalDate(), loginDate);
            if (daysBetween == 1) {
                statsDao.updateDate(user.getId(), stats.getDays() + 1, java.sql.Date.valueOf(loginDate));
            } else if (daysBetween > 1) {
                statsDao.updateDate(user.getId(), 0, java.sql.Date.valueOf(loginDate));
            }
            session.setAttribute("stats", stats);
        } else {
            stats = new Stats();
            stats.setDays(0);
            stats.setHours(0);
            stats.setUserId(user.getId());
            stats.setLoginLastest(java.sql.Date.valueOf(loginDate));
            statsDao.insert(stats);
            session.setAttribute("stats", stats);
        }
        String formattedHours = String.format("%.3f", stats.getHours());
        session.setAttribute("formattedHours", formattedHours);
        session.setAttribute("days", stats.getDays());

        if (user.getRoleId() == 2) {
            response.sendRedirect(request.getContextPath() + "/UserHome.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin-home");
        }

    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString(StandardCharsets.UTF_8);

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").getAsString();
        return accessToken;
    }

    public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString(StandardCharsets.UTF_8);

        UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);
        // Chuyển đổi từ ISO-8859-1 sang UTF-8 cho trường name
        googlePojo.setName(new String(googlePojo.getName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        googlePojo.setGiven_name(new String(googlePojo.getGiven_name().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        googlePojo.setFamily_name(new String(googlePojo.getFamily_name().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        return googlePojo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
