package com.example.SampleProject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "finance_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceMaster {

    // id, agent name, acc no, nift id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "account_number")
    private Long accountNum;

    @Column(name = "nift_id")
    private Long niftId;

    @JsonManagedReference
    @OneToMany( mappedBy = "financeMaster",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<FinanceAccount> financeAccount;

}
