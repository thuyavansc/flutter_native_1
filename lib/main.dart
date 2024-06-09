import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Intent Test',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
      routes: {
        '/FullScreenAlarmPage': (context) {
          final args = ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>?;
          return FullScreenAlarmPage(
            title: args?['title'] ?? 'Alarm',
            description: args?['body'] ?? 'Alarm triggered',
          );
        },
      },
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  static const platform = MethodChannel('your_channel_name');
  static const alarmChannel = MethodChannel('com.example.flutter_screen_open_from_android_intent_1/alarm');

  @override
  void initState() {
    super.initState();
    alarmChannel.setMethodCallHandler((call) async {
      if (call.method == "openAlarmPage") {
        final args = call.arguments as Map<String, dynamic>;
        Navigator.pushNamed(context, '/FullScreenAlarmPage', arguments: args);
      }
    });
  }

  Future<void> _openAlarmScreenNative() async {
    try {
      await platform.invokeMethod('startFullScreenActivity', {
        'title': 'Alarm Title',
        'body': 'Alarm Body',
      });
    } on PlatformException catch (e) {
      print("Failed to open screen: '${e.message}'.");
    }
  }

  void _navigateWithFlutter(BuildContext context) {
    Navigator.pushNamed(
      context,
      '/FullScreenAlarmPage',
      arguments: {'title': 'Alarm Title', 'body': 'Alarm Body'},
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Page'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: _openAlarmScreenNative,
              child: Text('Navigate with Native Android'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => _navigateWithFlutter(context),
              child: Text('Navigate with Flutter'),
            ),
          ],
        ),
      ),
    );
  }
}

class FullScreenAlarmPage extends StatelessWidget {
  final String title;
  final String description;

  FullScreenAlarmPage({required this.title, required this.description});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(description),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context);
              },
              child: Text('Stop Alarm'),
            ),
          ],
        ),
      ),
    );
  }
}



// void main() {
//   runApp(const MyApp());
// }
//
// class MyApp extends StatelessWidget {
//   const MyApp({super.key});
//
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Flutter Demo',
//       theme: ThemeData(
//         colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
//         useMaterial3: true,
//       ),
//       home: const MyHomePage(title: 'Flutter Demo Home Page'),
//     );
//   }
// }
//
// class MyHomePage extends StatefulWidget {
//   const MyHomePage({super.key, required this.title});
//
//   final String title;
//
//   @override
//   State<MyHomePage> createState() => _MyHomePageState();
// }
//
// class _MyHomePageState extends State<MyHomePage> {
//   int _counter = 0;
//
//   void _incrementCounter() {
//     setState(() {
//
//       _counter++;
//     });
//   }
//
//   @override
//   Widget build(BuildContext context) {
//
//     return Scaffold(
//       appBar: AppBar(
//
//         backgroundColor: Theme.of(context).colorScheme.inversePrimary,
//
//         title: Text(widget.title),
//       ),
//       body: Center(
//
//         child: Column(
//
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: <Widget>[
//             const Text(
//               'You have pushed the button this many times:',
//             ),
//             Text(
//               '$_counter',
//               style: Theme.of(context).textTheme.headlineMedium,
//             ),
//           ],
//         ),
//       ),
//       floatingActionButton: FloatingActionButton(
//         onPressed: _incrementCounter,
//         tooltip: 'Increment',
//         child: const Icon(Icons.add),
//       ), // This trailing comma makes auto-formatting nicer for build methods.
//     );
//   }
// }
