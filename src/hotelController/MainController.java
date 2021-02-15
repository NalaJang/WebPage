package hotelController;

import java.util.ArrayList;
import java.util.Map;

import hotelDao.HotelRoomDao;
import hotelDao.PenguinBoardDao;
import hotelDao.ShopProductDao;
import hotelDto.PenguinBoardVo;
import hotelDto.ProductVo;
import hotelDto.RoomInfoVo;
import projectControls.Component;
import projectControls.Controller;

@Component("/hotel/main.do")
public class MainController implements Controller{
	
	private ShopProductDao productDao;
	public MainController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
	
	private HotelRoomDao roomDao;
	public MainController setRoomDao(HotelRoomDao roomDao) {
		this.roomDao = roomDao;
		return this;
	}
	
	private PenguinBoardDao penguinDao;
	public MainController setPenguinDao(PenguinBoardDao penguinDao) {
		this.penguinDao = penguinDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ArrayList<ProductVo> bestList = productDao.listBestProduct();		//베스트 상품 리스트
		model.put("bestItem", bestList);
		
		ArrayList<RoomInfoVo> roomList = roomDao.roomList();				//객실 리스트
		model.put("roomList", roomList);
		
		ArrayList<PenguinBoardVo> boardList = penguinDao.boardList_main();	//펭귄이야기 리스트
		model.put("boardList", boardList);
		
		return "/hotel/main.jsp";	//redirect x
	}
}
