// 날씨 정보를 얻어보자!

#include "WiFiEsp.h"

String line0 = ""; // 파싱해서 불러올 공간
char ssid[] = "Chicken_Attack";            // your network SSID (name)
char pass[] = "999999999";        // your network password
int status = WL_IDLE_STATUS;     // the Wifi radio's status

// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000
// 날씨 정보 RSS

// Initialize the Ethernet client object
WiFiEspClient client;

void setup() {
        Serial.begin(9600);  //시리얼모니터
        Serial3.begin(9600);   //와이파이 시리얼  // esp-01과 통신하는 Baud Rate // AT+UART_DEF=9600,8,1,0,0 명령에 의해 /9600으로 set...
        WiFi.init(&Serial3);   // initialize ESP module
        while ( status != WL_CONNECTED) {   // attempt to connect to WiFi network
                Serial.print("Attempting to connect to WPA SSID: ");
                Serial.println(ssid);
                status = WiFi.begin(ssid, pass);    // Connect to WPA/WPA2 network
        }
        Serial.println("You're connected to the network");
        printWifiStatus(); // wifi 상태표시 및 딜레이
        Serial.println();
        pasing();//날씨 파싱
}


void loop() {

}

void printWifiStatus() { // 와이파이 정보 출력!
        Serial.print("SSID: ");   // print the SSID of the network you're attached to
        Serial.println(WiFi.SSID());
        IPAddress ip = WiFi.localIP();  // print your WiFi shield's IP address
        Serial.print("IP Address: ");
        Serial.println(ip);
        long rssi = WiFi.RSSI();  // print the received signal strength
        Serial.print("Signal strength (RSSI):");
        Serial.print(rssi);
        Serial.println(" dBm");
}

void pasing(void)
{

        // http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000
        // 날씨 정보 RSS
        int count = 0;
        const char* host = "www.kma.go.kr";  // 호스트
        char url[100];
        sprintf(url, "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000");
        Serial.println(url);

        delay(100);
        if (client.connect(host, 80)) {
                Serial.println("Connected to server");
                client.print("GET ");    // Make a HTTP request
                client.print(url);
                client.print(" HTTP/1.1\r\n");
                client.print("Host: ");
                client.print(host);
                client.print("\r\n");
                client.print("Connection: open\r\n\r\n");
        }

        delay(100); //와이파이 대기 내부처리
        while (client.available()) {
                char c = client.read();
                Serial.write(c);
                if (c == '<') count++;

                if (count > 50 && count <= 150) line0 += c;
                else if (count > 150) break; //line0에 일부구간만 문자열 받기
        }

        delay(100);
        if (!client.connected()) {
                Serial.println();
                Serial.println("Disconnecting from server...");
                client.stop();

        }



        Serial.print(F("show all parsing char: ")); Serial.println(line0 ); // 읽어들인 문자열을 전부 보여줌
        String temp;  //
        delay(100);
        int temp_start = line0.indexOf(F("<temp>")); // line0의 읽어 들인 문자열의 시작 "<temp>"부터 파싱 시작
        delay(100);
        int temp_end = line0.indexOf(F("</temp>")); // line0의 읽어 들인 문자열의 끝 "</temp>"부터 파싱 끝
        delay(100);
        temp = line0.substring(temp_start + 6 , temp_end); //"<temp>" 문자 크기 6만큼 쉬프트해서 제거
        delay(100);
        Serial.print(F("온도 : ")); Serial.println(temp);
        client.stop();

}
