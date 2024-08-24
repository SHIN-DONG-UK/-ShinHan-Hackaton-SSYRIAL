import 'package:flutter/material.dart';
import 'package:ssyrial/screens/account/tranfer/account_transfer_start_screen.dart';
import 'package:ssyrial/screens/guide/stt_screen.dart';
import 'package:ssyrial/widgets/custom_dialog.dart';

class FunctionSelectionScreen extends StatelessWidget {
  final String title; // 화면 제목
  final String subtitle; // 설명 텍스트
  final TextStyle? titleTextStyle; // 제목 텍스트 스타일
  final TextStyle? subtitleTextStyle; // 설명 텍스트 스타일
  final List<String> buttonLabels; // 버튼 텍스트 목록
  final TextStyle? buttonTextStyle; // 버튼 텍스트 스타일
  final Color buttonColor; // 버튼 배경색
  final Color otherButtonColor; // "다른 기능 찾기" 버튼 배경색
  final String otherButtonText; // "다른 기능 찾기" 버튼 텍스트
  final EdgeInsetsGeometry padding; // 전체 화면 패딩
  final IconData micIcon; // 마이크 아이콘

  const FunctionSelectionScreen({
    Key? key,
    this.title = 'SSYRIAL_MAIN',
    this.subtitle = '도움이 필요한 기능을 선택해 주세요',
    this.titleTextStyle,
    this.subtitleTextStyle,
    this.buttonLabels = const ['돈 넣기', '돈 찾기', '돈 보내기', '통장 조회'],
    this.buttonTextStyle,
    this.buttonColor = Colors.green, // 기본 버튼 배경색
    this.otherButtonColor = Colors.orange, // "다른 기능 찾기" 버튼 색상
    this.otherButtonText = '다른 기능 찾기', // "다른 기능 찾기" 기본 텍스트
    this.padding = const EdgeInsets.all(16.0), // 기본 패딩
    this.micIcon = Icons.mic, // 기본 마이크 아이콘
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title, style: titleTextStyle), // 화면 제목
      ),
      body: Padding(
        padding: padding, // 전체 화면 패딩 설정
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(subtitle, style: subtitleTextStyle), // 설명 텍스트
            SizedBox(height: 20),
            GridView.count(
              crossAxisCount: 2,
              shrinkWrap: true,
              childAspectRatio: 3,
              mainAxisSpacing: 16,
              crossAxisSpacing: 16,
              children: buttonLabels.map((label) {
                return ElevatedButton(
                  onPressed: () {
                    if (label == '돈 보내기') {
                      // Navigate to SendMoneyScreen when "돈 보내기" is pressed
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => AccountTransferStartScreen()),
                      );
                    } else {
                      // Handle other buttons if needed
                    }
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: buttonColor, // 버튼 배경색 설정
                  ),
                  child: Text(label, style: buttonTextStyle), // 버튼 텍스트 및 스타일 설정
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // "다른 기능 찾기" 버튼 클릭 시 동작
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: otherButtonColor, // "다른 기능 찾기" 버튼 배경색 설정
              ),
              child: Text(otherButtonText, style: buttonTextStyle), // 버튼 텍스트 및 스타일 설정
            ),
            Spacer(),
            Text('또는 버튼을 누르고 말해보세요'),
            IconButton(
              icon: Icon(micIcon), // 마이크 아이콘 설정
              onPressed: () {
                // 마이크 아이콘 클릭 시 동작
                showDialog(
                  context: context,
                  builder: (context) => CustomDialog(child: STTScreen()),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
