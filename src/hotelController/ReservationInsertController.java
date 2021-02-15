package hotelController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.RoomReservation;
import hotelDto.HotelMemberVo;
import hotelDto.ReservationVo2;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/reservationInsert.do")
public class ReservationInsertController implements Controller, DataBinding{

	private RoomReservation reservation;
	
	public ReservationInsertController setReservation(RoomReservation reservation) {
		this.reservation = reservation;
		return this;
	}	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		if(memberVo == null) {
			
			return "/hotel/login.jsp";
		} else {
			
			/*
			String[] cseqArr = cseq.split(",");
			
			for(String values : cseqArr) {

				if(!values.equals("")) {
					
					cseq = values;
				}
			}
			 */
			ReservationVo2 rv2 = (ReservationVo2)model.get("rv2");
			
			int cseq = (Integer)model.get("cseq");
			
			rv2.setEmail(memberVo.getEmail());
			rv2.setAddress1(memberVo.getAddress1());
			
			int rseq = (Integer)model.get("rseq");
			int rvseq = 0;
			int result = 0;
			
			try {
				result = reservation.insert(rv2);

				if (result > 0) {

					rvseq = reservation.getRvseq(memberVo.getEmail());

					if (rvseq > 0) {

						reservation.updateRoomCart(memberVo.getEmail(), rseq);

					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:../hotel/reservationList.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"rv2", ReservationVo2.class, "cseq", Integer.class , "rseq", Integer.class};
	}

}
