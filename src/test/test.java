package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import setting.Stringctl;

public class test {
	String value;
	public test(String string) {
		value = string ;
	}

	public static void main(String[] args) {
		String v = ("('2016', 'Aston Martin', 'Rapide S 6.0 V12', '1380', '�T�o', '�۵M�i��, V��12��, DOHC���Y���b, 48���', '5935cc', '558hp@6750rpm', '63.2kgm@5500rpm', 'null', '10.9', 'null', '����X��', '6�t��۱�', '��A�u', '��A�u', '�e��з�', '245/40R20 295/35R20', '�⨮', '5��', '4�H�y', '5020mm', '2140mm', '1350mm', '1990kg', '2989mm', '750ltr', 'null', '90.5ltr', '4.43km/ltr', '9.45km/ltr', '6.7km/ltr', '69,690��', '13,080��', '�e���O, �����O, HID�I���Y�O, LED���O, ��UV����', '���ɼ���, ��V�L�q�ʽվ�, ��ŪŽ�, ���Ϸű�, ���йL�o��, �r�p�y�q�ʽվ�, �r�p�y��m�O��, �k�e�y�q�ʽվ�, �k�e�y��m�O��, ���e�y�q����, ���{�q��, �e�y�ߤ�, ��y�ߤ�, �e�y�M�[, ��y�M�[, ��y�X���f', 'CD���T�D��, MP3����\��, �Ť��q�T, 14�u���n��', '�K�_�ͱҰʨ�����, �w�t����, ���說�˨����U�t��, �e��n���p�F, ���P���۰��Y�O, �B�w�P���B��, �q�ʵ������\��', '���s�t��, �w�����w���a, ���e�y�������n, ���e�y�������n, ���ؤo�Y����î, ���ꦺ�٨��t��, �٨��O�D���t�t��, �q�l�٨��O�D���U�t��, �`�񨾷Ʊ���t��, �L���ʱ�', 'http://tw-autos.zenfs.com/MMT/car/c496b58b1b450b1d36b954eb8c5cc0f7_1200.jpg, http://tw-autos.zenfs.com/MMT/car/7ba26627a3a149ae4774a7f543a20ea6_1200.jpg, http://tw-autos.zenfs.com/MMT/car/f791c6b8eb8d03023fdff021383c8f58_1200.jpg, http://tw-autos.zenfs.com/MMT/car/874a47856f34853df45688940ed91506_1200.jpg, http://tw-autos.zenfs.com/MMT/car/8c0b1edefabd35ed0298323a5e144ac8_1200.jpg, http://tw-autos.zenfs.com/MMT/car/bfa1663801ea89ed3b1229315cc16474_1200.jpg, http://tw-autos.zenfs.com/MMT/car/2ff325ea2aecf89d16edbde62f4d11a3_1200.jpg, http://tw-autos.zenfs.com/MMT/car/aa7f779c7718c953290e8a6be3a007d5_1200.jpg, http://tw-autos.zenfs.com/MMT/car/638d1b66107b68a3e434a1ca592de258_1200.jpg, http://tw-autos.zenfs.com/MMT/car/7e1faba94b9a987f6c8f31921624fca8_1200.jpg')\n"
				+"('2016', 'Aston Martin', 'Vanquish 6.0 V12', '1680', '�T�o', '�۵M�i��, V��12��, DOHC���Y���b, 48���', '5935cc', '573hp@6750rpm', '63.2kgm@5500rpm', 'null', '11', 'null', '����X��', '6�t��۱�', '��A�u', '��A�u', '�e��з�', '255/35R20 305/30R20', '������]��, �W�Ŷ]��', '2��', '2�H�y', '4728mm', '1912mm', '1294mm', '1739kg', '2740mm', '368ltr', 'null', '78ltr', '4.68km/ltr', '10.67km/ltr', '7.3km/ltr', '69,690��', '13,080��', '�e���O, �����O, HID�I���Y�O, LED���O, ��UV����', '��V�L�ֱ���, ���ɼ���, ��V�L�q�ʽվ�, ��ŪŽ�, ���Ϸű�, ���йL�o��, �r�p�y�q�ʽվ�, �r�p�y��m�O��, �k�e�y�q�ʽվ�, �k�e�y��m�O��, ���e�y�q����, ���{�q��, �e�y�ߤ�, �e�y�M�[', 'CD���T�D��, MP3����\��, �Ť��q�T, 14�u���n��', '�K�_�ͱҰʨ�����, �w�t����, ���說�˨����U�t��, �e��n���p�F, ���P���۰��Y�O, �B�w�P���B��, �q�ʵ������\��', '���s�t��, �w�����w���a, ���e�y�������n, ���e�y�������n, ���ꦺ�٨��t��, �٨��O�D���t�t��, �q�l�٨��O�D���U�t��, �`�񨾷Ʊ���t��, �L���ʱ�', 'http://tw-autos.zenfs.com/MMT/car/0c1545f3c3de0a5e2c5d2882a493ae39_1200.jpg, http://tw-autos.zenfs.com/MMT/car/c4651067e070cf2a5e7d9c9869d1619c_1200.jpg, http://tw-autos.zenfs.com/MMT/car/734aeeb9c7f13f0aa3591b71b339af49_1200.jpg, http://tw-autos.zenfs.com/MMT/car/3663418d49b77f7f359cd18ad505828b_1200.jpg, http://tw-autos.zenfs.com/MMT/car/ebacd63327f11343a37442b9f8ec8743_1200.jpg, http://tw-autos.zenfs.com/MMT/car/af75309d94a8c5a24964b3aced87e685_1200.jpg, http://tw-autos.zenfs.com/MMT/car/1437dc135dd127a4a7dd76906123d069_1200.jpg, http://tw-autos.zenfs.com/MMT/car/80e2ddb22a0286259357d0706aad795c_1200.jpg, http://tw-autos.zenfs.com/MMT/car/99ec338346f4408cb8190c0986860b92_1200.jpg, http://tw-autos.zenfs.com/MMT/car/ef61e454907919961acd6d621002c8b3_1200.jpg')\n"
				+"('2016', 'Aston Martin', 'Vantage V12 S', '1280', '�T�o', '�۵M�i��, V��12��, DOHC���Y���b, 48���', '5935cc', '573hp@6750rpm', '63.2kgm@5500rpm', 'null', '11', 'null', '����X��', '7�t�ۤ��', '��A�u', '��A�u', '�e��з�', '255/35R19 295/30R19', '������]��, �W�Ŷ]��', '2��', '2�H�y', '4385mm', '1865mm', '1250mm', '1665kg', '2600mm', 'null', 'null', '80ltr', '4.23km/ltr', '9.84km/ltr', '6.6km/ltr', '69,690��', '13,080��', '�e���O, �����O, HID�I���Y�O, LED���O, �ŤO�M��', '��V�L�ֱ���, ���ɼ���, ��ŪŽ�, ���Ϸű�, ���йL�o��, ���e�y�]���y��, ���{�q��, �e�y�ߤ�, �e�y�M�[', 'CD���T�D��, MP3����\��, �Ť��q�T, 10�u���n��', '�K�_�ͱҰʨ�����, �w�t����, ���說�˨����U�t��, ���P���۰��Y�O, �B�w�P���B��, �q�ʵ������\��', '���s�t��, �w�����w���a, ���e�y�������n, ���e�y�������n, ���ꦺ�٨��t��, �٨��O�D���t�t��, �q�l�٨��O�D���U�t��, �`�񨾷Ʊ���t��, �L���ʱ�', 'http://tw-autos.zenfs.com/MMT/car/d115772903d8188c66d2a968721ee1c2_1200.jpg, http://tw-autos.zenfs.com/MMT/car/48d5f1ae5a5cd6f65c0e711f28b3cd1f_1200.jpg, http://tw-autos.zenfs.com/MMT/car/37fd259833dab682175a805c0e78123f_1200.jpg, http://tw-autos.zenfs.com/MMT/car/a765b49ec43aaa8aeaef0d2405ab55f2_1200.jpg, http://tw-autos.zenfs.com/MMT/car/30081dcfcbed319a433fff6dcade805c_1200.jpg, http://tw-autos.zenfs.com/MMT/car/407b5c55c38201a13080be65f70a2345_1200.jpg, http://tw-autos.zenfs.com/MMT/car/f64a955140c48f20e32c76423c2ac128_1200.jpg, http://tw-autos.zenfs.com/MMT/car/4f89b58a0743c19d51b9db0987816f21_1200.jpg, http://tw-autos.zenfs.com/MMT/car/29e9b5b8fb6a41191ed29bd60f9f890b_1200.jpg, http://tw-autos.zenfs.com/MMT/car/f3cf0bda2dcd38bb12cca5848e69c26b_1200.jpg')\n"
				+"('2016', 'Audi', 'A1 25 TFSI', '112', '�T�o', '�����W��, ���C3��, DOHC���Y���b, 12���', '999cc', '95hp@5000~5500rpm', '16.3kgm@1500~3500rpm', 'null', '10.5', 'null', '�e���X��', '�����X��7�t�ۤ��', '�����', '�h�s��', '�e��з�', '185/60R15', '�ȭI��', '3��', '5�H�y', '3973mm', '1740mm', '1416mm', '1065kg', '2469mm', '270ltr', '920ltr', '45ltr', '16.08km/ltr', '21.62km/ltr', '19.2km/ltr', '4,320��', '4,320��', 'LED���O, ��UV����', '���йL�o��, ´���y��, ��y��������, ���{�q��, �e�y�M�[', '�����ù�, CD���T�D��, MP3����\��, �Ť��q�T, 8�u���n��', '�q�ʵ������\��', '���s�t��, �w�����w���a, ���e�y�������n, ���e�y�������n, ���ؤo�Y����î, ���ꦺ�٨��t��, �٨��O�D���t�t��, �`�񨾷Ʊ���t��, �שY�_�B���U, ISOFIX�ൣ�w���ȩT�w, �L���ʱ�', 'http://tw-autos.zenfs.com/MMT/car/2218590fac09a7c6dec2992421ae5c26_1200.jpg, http://tw-autos.zenfs.com/MMT/car/8ea5df6a2ac62927c128199d2e16c496_1200.jpg, http://tw-autos.zenfs.com/MMT/car/b5a3889c6b73bcc3896d1b67ad1f8bee_1200.jpg, http://tw-autos.zenfs.com/MMT/car/fd85b6d7be1398987a6dfa1310438792_1200.jpg, http://tw-autos.zenfs.com/MMT/car/e51526b3ac5a9a879824e18532f7e589_1200.jpg, http://tw-autos.zenfs.com/MMT/car/91c83c3a22324244f330082a05e0a9c9_1200.jpg, http://tw-autos.zenfs.com/MMT/car/792716707d8542a9ee52fcd93d26ddd3_1200.jpg, http://tw-autos.zenfs.com/MMT/car/9e48d6a754c926247722b0a2016c49bb_1200.jpg, http://tw-autos.zenfs.com/MMT/car/9b046286a1567b2dc2fcf468f8f38ffe_1200.jpg, http://tw-autos.zenfs.com/MMT/car/28ec54a86dddd207ec9316792642a9f3_1200.jpg')\n"
				+"('2016', 'Audi', 'A1 30 TFSI', '136', '�T�o', '�����W��, ���C4��, DOHC���Y���b, 16���', '1395cc', '125hp@5000rpm', '20.4kgm@1500~4000rpm', 'null', '10', 'null', '�e���X��', '�����X��7�t�ۤ��', '�����', '�h�s��', '�e��з�', '215/45R16', '�ȭI��', '3��', '5�H�y', '3973mm', '1740mm', '1416mm', '1115kg', '2469mm', '270ltr', '920ltr', '45ltr', '14.77km/ltr', '20km/ltr', '17.7km/ltr', '7,120��', '4,800��', '�e���O, LED���O, HID�I���Y�O, LED���O, ��UV����', '��V�L�ֱ���, ��ŪŽ�, ���йL�o��, ´���y��, ��y��������, ���{�q��, �e�y�M�[', '�����ù�, CD���T�D��, MP3����\��, �Ť��q�T, USB����, 8�u���n��', '�q�ʵ������\��', '���s�t��, �w�����w���a, ���e�y�������n, ���e�y�������n, ���ؤo�Y����î, ���ꦺ�٨��t��, �٨��O�D���t�t��, �`�񨾷Ʊ���t��, �שY�_�B���U, ISOFIX�ൣ�w���ȩT�w, �L���ʱ�', 'http://tw-autos.zenfs.com/MMT/car/ebf1ae34f5c014af813ae725d76df913_1200.jpg, http://tw-autos.zenfs.com/MMT/car/3f31ef280edc30675e20807dbc48994d_1200.jpg, http://tw-autos.zenfs.com/MMT/car/42d3ba140864a6f943be140306cbcc09_1200.jpg, http://tw-autos.zenfs.com/MMT/car/2ea80fc7ae11ea461971fc0a053cdc5f_1200.jpg, http://tw-autos.zenfs.com/MMT/car/d5a4eb8a81734c2eba21c2bacbc0d8a7_1200.jpg, http://tw-autos.zenfs.com/MMT/car/aaa10a6ca8237e5924e5ddc6519b6a76_1200.jpg, http://tw-autos.zenfs.com/MMT/car/c56acd5e3be73a8d10199b0449bad404_1200.jpg, http://tw-autos.zenfs.com/MMT/car/f94a322b8354ab054066c515ddc20570_1200.jpg, http://tw-autos.zenfs.com/MMT/car/b88e573e32c4098550ad3b0e81c0c638_1200.jpg, http://tw-autos.zenfs.com/MMT/car/4f2667b7a71e6bce9015d8e8b0028497_1200.jpg')\n");
		String va = "";
		for(int i = 0 ; i<20;i++){
			va= va +v ;
		}
		new test(va).start();
	}
	void start(){
		System.out.println("Start time : "+new SimpleDateFormat("hh:mm:ss").format(new Date()));
		//String value = this.value.split("\n")[0] ;
		String insql="",upsql="";
		String [] upvalue = new String [38];
		//
		String [][] column_name = new Stringctl().getColumn_name();
		String col_name_sql = "";
		Z:
		for(String v [] : column_name)
			for(String V : v){
				if(V.startsWith("REMARK"))break Z;
				col_name_sql = col_name_sql + V + ", ";
			}
		String [] colName = col_name_sql.split(", ");
		//
		for(String value : this.value.split("\n")){
			String colValue []  = value.substring(2,value.length()-2).split("', '");
			
			//2016 Aston Martin Rapide S 6.0 V12
			String RealName = (colValue[0]+" "+colValue[1]+" "+colValue[2]);
			//
			
			insql = insql + value +", ";
			for(int i = 3,j=0; i<40 ;i++,j++){
				upvalue[j] = (upvalue[j]==null?colName[i]+" = case concat(�~��,' ',�~�P,' ',�ڦ�) ":upvalue[j]) + "when '"+ RealName + "' then '" +colValue[i]+"'"; 
			}
			upvalue[37] = (upvalue[37]==null?"":upvalue[37]) +"'"+ RealName +"', ";
			
			
			//
		}
		
		for(int i = 0; i<37 ;i++){
			upsql = upsql + (upvalue[i]) + "END, ";
		}
		
		if(!insql.equals(""))
		insql = ("insert allcar value"
				+ insql.substring(0,insql.length()-2)
				);
		
		if(!upsql.equals(""))
			upsql=("update allcar set "
					+ upsql.substring(0,upsql.length()-2)
					+ " where concat(�~��,' ',�~�P,' ',�ڦ�) in ("+upvalue[37].substring(0,upvalue[37].length()-2)+")");
		System.out.println("End   time : "+new SimpleDateFormat("hh:mm:ss").format(new Date()));
	}
}
