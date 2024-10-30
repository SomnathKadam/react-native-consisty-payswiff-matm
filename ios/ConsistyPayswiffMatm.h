
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNConsistyPayswiffMatmSpec.h"

@interface ConsistyPayswiffMatm : NSObject <NativeConsistyPayswiffMatmSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ConsistyPayswiffMatm : NSObject <RCTBridgeModule>
#endif

@end
