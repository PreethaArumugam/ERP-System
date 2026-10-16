package com.example.SampleProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "finance_account")
@Getter
@Setter
@NoArgsConstructor
public class FinanceAccount {

    // separate table-> bank details - id, ifsc code, branch code, acc no, acc name, finance_master_id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "finance_account_number")
    private Long financeAccNum;

    @Column(name = "finance_account_name")
    private String financeAccName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "finance_master_id")
    private FinanceMaster financeMaster;
}
