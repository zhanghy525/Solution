import java.math.*;
public class TestDataType6{
	public static void main(String[] args){
		
		//�������͵ĸ�ֵ��ʽ��

		int num1 = 24;//ͨ��ʮ���ƽ��и�ֵ *****
		//=====================================
		int num2 = 024;//ͨ���˽��ƽ��и�ֵ
		int num3 = 0x24;//ͨ��ʮ�����ƽ��и�ֵ
		int num4 = 0b1011;//ͨ�������ƽ��и�ֵ   jdk7.0

		System.out.println(num1);//24
		System.out.println(num2);//024 = 2 * 8(1) + 4 * 8(0) = 16 + 4 = 20
		System.out.println(num3);//0x24 = 2 * 16(1) + 4 * 16(0) = 32 + 4 = 36
		System.out.println(num4);

		//81 + 8 * 8(1) + 1 * 8(0) + 8 * 16(1) + 1 * 16(0) =
		//System.out.println(81 + 081 + 0x81);

		//�����ƣ�0  1
		//�˽��ƣ�0 -7
		//ʮ�����ƣ�0 - 9    a - f

		System.out.println(64_735_648);

		//System.out.println(2.0 - 1.1);//17.1

		BigDecimal b1 = new BigDecimal("2.0");
		BigDecimal b2 = new BigDecimal("1.1");

		BigDecimal b3 = b1.subtract(b2);

		System.out.println(b3);

		/**
		1:  2.0-1.1���Ϊ���٣�
			��������0.9

		2�� Ϊʲô���������Ľ����
			��java���κ�һ�������������ö����ƾ�ȷ�ı�ʾ����
			���ǲ������κ�һ��С��Ҳ���������޵�λ������
			��ʾ���� ����1.1��������ֵλ�Ľ�ȡ ������ֵ����ȷ

		3�� ��ô�����
			��ֵ����100�� ��λ��С100��


		*/
		BigDecimal b1 = new BigDecimal("1.0");

		for (int x = 1; x <= 10; x++) {
			BigDecimal b2 = new BigDecimal("0.1");
			b1 = b1.add(b2);
			System.out.println(b1);
		}



	}
}