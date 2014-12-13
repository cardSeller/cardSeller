package com.card.seller.backoffice.service;

import com.card.seller.dao.MemberDao;
import com.card.seller.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by minjie
 * Date:14-12-11
 * Time:下午5:51
 */
@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Transactional
    public List<Member> getAllMembers() {
        return memberDao.getAll();
    }
}
