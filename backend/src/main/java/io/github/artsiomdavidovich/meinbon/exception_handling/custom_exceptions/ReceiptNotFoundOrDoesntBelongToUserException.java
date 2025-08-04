package io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions;

public class ReceiptNotFoundOrDoesntBelongToUserException extends RuntimeException {
    public ReceiptNotFoundOrDoesntBelongToUserException(Long receiptId, Long userId) {
        super(String.format("Receipt with id: %d doesn't exist or belong to User with id: %d", receiptId, userId));
    }
}
