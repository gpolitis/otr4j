package net.java.otr4j.session;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.List;

import net.java.otr4j.OtrEngineListener;
import net.java.otr4j.OtrException;
import net.java.otr4j.OtrPolicy;
import net.java.otr4j.io.messages.AbstractMessage;

public interface Session {

	public abstract SessionStatus getSessionStatus();

	public abstract SessionID getSessionID();

	public abstract void injectMessage(AbstractMessage m) throws OtrException;

	public abstract KeyPair getLocalKeyPair() throws OtrException;

	public abstract OtrPolicy getSessionPolicy();

	public abstract String transformReceiving(String content)
			throws OtrException;

	public abstract String transformSending(String content, List<TLV> tlvs)
			throws OtrException;

	public abstract void startSession() throws OtrException;

	public abstract void endSession() throws OtrException;

	public abstract void refreshSession() throws OtrException;

	public abstract PublicKey getRemotePublicKey();

	public abstract void addOtrEngineListener(OtrEngineListener l);

	public abstract void removeOtrEngineListener(OtrEngineListener l);

	public abstract void initSmp(String question, String secret)
			throws OtrException;

	public abstract void respondSmp(String question, String secret)
			throws OtrException;

	public abstract void abortSmp() throws OtrException;
	
	public abstract boolean isSmpInProgress();

	public abstract BigInteger getS();
}