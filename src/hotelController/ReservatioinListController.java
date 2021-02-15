package hotelController;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hotelDao.RoomReservation;
import hotelDto.HotelMemberVo;
import hotelDto.ReservationVo2;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/reservationList.do")
public class ReservatioinListController implements Controller {

	private RoomReservation reservation;
	public ReservatioinListController setReservation(RoomReservation reservation) {
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
			System.out.println(memberVo.getEmail());
			System.out.println(memberVo.getName());
			List<ReservationVo2> reservationList = reservation.reservationList(memberVo.getEmail());
			
			model.put("reservationList", reservationList);
			
			return "/hotel/roomReservationList.jsp";
		}
	}

}
