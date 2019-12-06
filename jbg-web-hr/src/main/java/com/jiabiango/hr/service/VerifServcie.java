package com.jiabiango.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiabiango.hr.mapper.VerifMapper;
import com.jiabiango.hr.model.Demo;
import com.jiabiango.hr.model.Verif;

@Service
public class VerifServcie {
    @Autowired
    private VerifMapper verifMapper;

    public Verif get(String phoneNumber) {
        return verifMapper.selectByPrimaryKey(phoneNumber);
    }

    public void save(Verif verif) {
    	verifMapper.insert(verif);
    }
    
    public void delete(String phoneNumber){
    	verifMapper.deleteByPrimaryKey(phoneNumber);
    }

}
