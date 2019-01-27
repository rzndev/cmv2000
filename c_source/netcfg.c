/*
	Simple udp client
*/
#define WIN32_LEAN_AND_MEAN
#include<stdio.h>	//printf
#include<string.h> //memset
#include<stdlib.h> //exit(0);
//#include<wininet.h>

#include<winsock2.h>
#include <ws2tcpip.h>
#include <windows.h>

#define SERVER "127.0.0.1"
#define BUFLEN 512	//Max length of buffer
#define PORT 8888	//The port on which to send data

struct SParam
{
  unsigned char addr;
  unsigned char val;
} __attribute__((aligned(1)));

void die(char *s)
{
	perror(s);
	exit(1);
}

int main(void)
{
  WSADATA wsaData;
  int iResult;
  iResult = WSAStartup(MAKEWORD(2,2), &wsaData);
  if (iResult != 0) {
    die("WSAStartup failed");
  }
	struct sockaddr_in si_other;
	int s, i, slen=sizeof(si_other);
	char buf[BUFLEN];
	char message[BUFLEN];

	if ( (s=socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP)) == -1)
	{
		die("socket");
	}

	memset((char *) &si_other, 0, sizeof(si_other));
	si_other.sin_family = AF_INET;
	si_other.sin_port = htons(PORT); 
        si_other.sin_addr.S_un.S_addr = inet_addr(SERVER);

iResult = bind(s, (SOCKADDR*)&si_other, sizeof(si_other));
    if (iResult == SOCKET_ERROR) {
        int error = WSAGetLastError();
printf("Socket bind failed. Error: %d\n", error);// << error << std::endl;
        exit(1);
    }

	while(1)
	{
//		printf("Enter message : ");
//		gets(message);
		
		//		//send the message
		//		if (sendto(s, message, strlen(message) , 0 , (struct sockaddr *) &si_other, slen)==-1)
		//		{
		//			die("sendto()");
		//		}
		
		//receive a reply and print it
		//clear the buffer by filling null, it might have previously received data
		memset(buf,'\0', BUFLEN);
		//try to receive some data, this is a blocking call
		if (recvfrom(s, buf, BUFLEN, 0, (struct sockaddr *) &si_other, &slen) == -1)
		{
printf("recvfrom() failed with error code : %d" , WSAGetLastError());
			die("recvfrom()");
		}

printf("size=%d\n",slen);
int len = *((unsigned char*)buf);//slen / sizeof(struct SParam);

printf("elements count %d\n", len);
struct SParam* data = (struct SParam*)((char*)buf+1);
		for(int i = 0; i < len; i++) {
		  unsigned int addr = data->addr;
		  unsigned int val = data->val;
		  printf("reg[%d]=%d\n", addr & 0x7f, val);
data++;
		}
printf("packet end\n");
		//puts(buf);
	}

	closesocket(s);
	return 0;
}
