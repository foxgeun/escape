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
	private final TimeRepository timeRepository;
	
	public Long saveReserve(ReserveDto reserveDto, String email, String time) throws Exception{
		Member member = memberRepository.findByEmail(email);
		
		Time bookTime = timeRepository.getTime(time);
		
		bookTime.updateTime(reserveDto.getDate());
		
		Reserve reserve = reserveDto.createReserve(member);
		
		reserveRepository.save(reserve);
		return reserve.getId();
		
	}
	
	public List<Reserve> findres(String email) throws Exception{
		return reserveRepository.findByModifiedBy(email);
	}
	
	public List<Reserve> getresList(){
		return reserveRepository.getresList();
	}
	
	public List<Reserve> getbtnList() {
		return reserveRepository.getbtnList();
	}
	
	public Reserve getwpqkfList(String date, String time) {
		return reserveRepository.getwpqkfList(date, time);
	}
	
	public List<Reserve> getwpqkfList2(String name ,String date, String time) {
		return reserveRepository.getwpqkfList2(name, date, time);
	}

	public List<Reserve> updateresList(int id){
		return reserveRepository.updateresList(id);
	}
	
	public Reserve updateres(int id) {
		return reserveRepository.updateres(id);
	}
	
	public void updateReserve(Reserve reserve, int id) {
		Reserve upreserve = reserveRepository.updateres(id);
		
		upreserve.updateReserve(reserve);
		
	}
	
	public void deleteReserve( int id) {
		Reserve upreserve = reserveRepository.updateres(id);
		
		reserveRepository.delete(upreserve);
		
	}
	
}
