package co.rsk.net.messages;

import co.rsk.net.light.messages.TransactionIndexRequestMessage;
import co.rsk.net.light.messages.TransactionIndexResponseMessage;
import org.ethereum.crypto.HashUtil;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class TransactionIndexResponseMessageTest {

    @Test
    public void createMessage() {
        long id = 0;
        byte[] blockHash = HashUtil.randomHash();
        long blockNumber = 1;
        long txIdx = 1;

        TransactionIndexResponseMessage message = new TransactionIndexResponseMessage(id, blockNumber, blockHash,txIdx);

        Assert.assertThat(message.getId(), is(id));
        Assert.assertThat(blockHash, is(message.getBlockHash()));
        Assert.assertThat(MessageType.TRANSACTION_INDEX_RESPONSE_MESSAGE, is(message.getMessageType()));
    }

    @Test
    public void accept() {
        long id = 0;
        byte[] blockHash = HashUtil.randomHash();
        long blockNumber = 1;
        long txIdx = 1;
        MessageVisitor visitor = mock(MessageVisitor.class);

        TransactionIndexResponseMessage message = new TransactionIndexResponseMessage(id, blockNumber, blockHash,txIdx);
        message.accept(visitor);

        verify(visitor, times(1)).apply(message);
    }

}