package me.appz4.beacon.dao;

import me.appz4.beacon.dao.base.BaseDaoImpl;
import me.appz4.beacon.model.model.Token;

public class TokenDaoImpl extends BaseDaoImpl<Token> implements TokenDao {

	public TokenDaoImpl() {
		super(Token.class);
	}

}
