package com.librarymanagement.libraryManagement.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagement.libraryManagement.Enums.TransactionStatus;
import com.librarymanagement.libraryManagement.Enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    private Integer fineAmount;

    public Transaction(TransactionStatus transactionStatus, TransactionType transactionType, Integer fineAmount) {
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.fineAmount = fineAmount;
    }

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private LibraryCard libraryCard;
}
