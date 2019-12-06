package com.jiabiango.hr.mapper;

import com.jiabiango.hr.model.Verif;

public interface VerifMapper {

    void insert(Verif verif);
    
    Verif selectByPrimaryKey(String phoneNumber);
    
    void deleteByPrimaryKey(String phoneNumber);
    
}