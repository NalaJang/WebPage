package hotelController;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.RoomReservation;
import hotelDto.HotelMemberVo;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/reservationDirect.do")
public class ReservationDirectController implements Controller, DataBinding{

	private RoomReservation reservation;
	public ReservationDirectController setReservation(RoomReservation reservation) {
		this.reservation = reservation;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		HotelMemberVo memberVo = (HotelMemberVo)session.getAttribute("hotelMember");
		
		
		int rseq = (Integer)model.get("rseq");
		Date checkin = (Date)model.get("checkin");
		Date checkout = (Date)model.get("checkout");
		int membernum = (Integer)model.get("membernum");
		
		reservation.insert_direct(memberVo.getEmail(), rseq, membernum, checkin, checkout);

//		return "redirect:../hotel/roomDetail.do?kind=" + kind;
		return "redirect:../hotel/reservationList.do";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"rseq", Integer.class, "membernum", Integer.class, "checkin", Date.class, "checkout", Date.class};
	}

}
