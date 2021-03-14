package com.example.BookStore.storage;

public class StorageFileNotFoundException extends com.example.BookStore.storage.StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
