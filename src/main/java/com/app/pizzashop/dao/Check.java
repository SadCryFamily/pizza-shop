package com.app.pizzashop.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_id")
    private Long checkId;

    @Column(name = "total_sum")
    private Long totalSum;

}
