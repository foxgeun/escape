package com.escape.Service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.escape.dto.ReserveDto;
import com.escape.entity.*;
import com.escape.repository.*;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReserveService {
	
	private final ReserveRepository reserveRepository;
	private final MemberRepository memberRepository;
	
	public Long saveReserve(ReserveDto reserveDto, String email) throws Exception{
		Member member = memberRepository.findByEmail(email);
		
		
		Reserve reserve = reserveDto.createReserve(member);
		
	
		reserveRepository.updateres(reserve.getName(),reserve.getCnt(), email,reserve.getUpdateTime(), reserve.getTime());
		return reserve.getId();
	}
	
	
	public List<Reserve> findres(String email) throws Exception{
		return reserveRepository.findByModifiedBy(email);
	}
	
	public List<Reserve> getresList(){
		return reserveRepository.getresList();
	}
	
	
	

	
	
	
}
