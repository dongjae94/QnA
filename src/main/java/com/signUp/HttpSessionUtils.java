package com.signUp;

import javax.servlet.http.HttpSession;

import com.signUp.domain.User;

public class HttpSessionUtils {
	public static final String USER_SESSION_KEY = "sessiondUser";

	public static boolean isLoginUser(HttpSession session) {
		Object sessiondUserd = session.getAttribute(USER_SESSION_KEY);
		if (sessiondUserd == null) {
			return false;
		}
		return true;
	}

	public static User getUserFromSession(HttpSession session) {
		if (!isLoginUser(session)) {
			return null;
		}

		return (User)session.getAttribute(USER_SESSION_KEY);

	}
}
