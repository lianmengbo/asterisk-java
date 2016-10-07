package org.asteriskjava.pbx;

import java.util.Date;
import java.util.List;

public interface Call
{
    /**
     * Used to identify which channel of a call an operation is to be performed
     * on. This is designed to stop the mis-use of some methods which operate on
     * a specific channel of a call. The Operand allows the caller to specify
     * which channel to operate on without having to explicitly pass in the
     * channel. Without this enum they could potentially pass in a channel which
     * is not owned by the call.
     * 
     * @author bsutton
     */

    public enum OperandChannel
    {
        /**
         * this party received (did not originate) the call
         */
        ACCEPTING_PARTY,

        /**
         * this party originated (dialled) the call
         */
        ORIGINATING_PARTY,

        TRANSFER_TARGET_PARTY,

        /**
         * is an end point that is on an external trunk
         */
        REMOTE_PARTY,
        /**
         * a local call is a handset attached directly (via sip) to the pbx
         */
        LOCAL_PARTY
    }

    boolean contains(Channel parkChannel);

    // public void callIsAnswering(iEndPoint answeredBy) throws PBXException;

    CallerID getAcceptingPartyCallerID();

    CallerID getOriginatingPartyCallerID();

    CallerID getRemotePartyCallerID();

    // void callDialedIn(iCallerID callerCallerID) throws PBXException;

    // void transferDeclined() throws PBXException;

    Date getCallStartTime();

    // Collection<iChannel> getChannels();

    Channel getOriginatingParty();

    Channel getAcceptingParty();

    Channel getTransferTargetParty();

    /**
     * retrieves the channel associated with the give Operand.
     * 
     * @param lhs
     * @return
     */
    Channel getOperandChannel(OperandChannel lhs);

    /**
     * This method use the CallDirection to determine which leg of the call is
     * the local call and which is the called/calling party. It then returns the
     * called/calling party.
     * 
     * @return
     */
    Channel getRemoteParty();

    /**
     * This method use the CallDirection to determine which leg of the call is
     * the local call and which is the called/calling party. It then returns the
     * local call .
     * 
     * @return
     */
    public Channel getLocalParty();

    boolean canSplit();

    CallDirection getDirection();

    List<Channel> getChannels();
}