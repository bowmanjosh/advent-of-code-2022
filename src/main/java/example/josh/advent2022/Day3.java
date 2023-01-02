package example.josh.advent2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

final class Day3 extends Day {
  final HashMap<Character, Integer> lookupTable;

  Day3() {
    lookupTable = new HashMap<>(52);

    char letter = 'a';
    for (int i = 0; i < 26; i++) {
      lookupTable.put(letter, i + 1);
      letter++;
    }

    letter = 'A';
    for (int i = 0; i < 26; i++) {
      lookupTable.put(letter, i + 27);
      letter++;
    }
  }

  @Override
  void part1() {
    var scanner = new Scanner(getRawInput());

    int prioritySum = 0;
    while (scanner.hasNext()) {
      final var rucksack = scanner.next();
      final var set = new HashSet<Character>();

      for (int i = 0; i < rucksack.length() / 2; i++) {
        set.add(rucksack.charAt(i));
      }

      for (int i = rucksack.length() / 2; i < rucksack.length(); i++) {
        if (set.contains(rucksack.charAt(i))) {
          prioritySum += lookupTable.get(rucksack.charAt(i));
          break;
        }
      }
    }

    System.out.println("Sum of all priorities: " + prioritySum);
  }

  @Override
  void part2() {
    System.out.println("Part 2 not done yet.");
  }

  private String getRawInput() {
    return """
        wgqJtbJMqZVTwWPZZT
        LHcTGHQhzrTzBsZFPHFZWFFs
        RnLRClzGzRGLGLGCNRjTMjJfgmffSffMqNgp
        WPLgsfLmLgqZvZgSRR
        RbwHdbDdQFFFMvvMjbhqhZZS
        lzTdldBDszfGcRsr
        ZjnhJjMjnbdnbHdFLmmfFLmnCCWFFl
        PpNwtRsNsZSsRwCfzQQBfQszCBsC
        PpwcqqVZRtbggggjcgJJ
        ntczBcVcgnHzgBHnVntcBBFhgsmmmssqWNWNWqLvNhsqTN
        bSSGdSDZbGSGdDmLmGTvTGmLFFhm
        PlFbDpJDPbPdPbZQZDZlSCDBfMVRwBzBtBQzfzRHVMVRtH
        fDVrmmrvcmCcVpfcfGlswpPwsttMpjJMPPjjtP
        RgSTdndFLbJqqPssWWjPWjPjHS
        FqgzQnTqJRRQqLLhTCDhDCDmcmlvvlhcVm
        nnqVtHbfVHZVmtlvmHtZtrFSFTRRFhRccTbrLsLSGr
        cCNJQJPJQgjjMQdDrGGsRhTFGFRFSpMS
        gzdCwWdjNPgzcJgjwdZtVlHHmvvmZlvffHnz
        FFgsgwNwWvggQsMWDwvQQvQcccdcJZDtJGBtVGGGtcVlzt
        rjfTrbjpjRSRTbTpzldjjHBtJGBdltJG
        RbrPTfpCfmbpmnfRRCvMvQWNBwFFgMsgBL
        zzLHgjjjdFHWbGBjjzcbgQRmSvqsSpmRsRSQSmRMWv
        ZfJVrwPhZhZlhQQqBSQSNSqM
        tnCfrDCltfPzHFFLBgngHz
        DCpwrrMhwCrCMVCpGFqpVDnWWTWBtnTWvWfvbbTdFWRv
        lmhhcsQPmTtTnnPBTB
        QmcjNJsJzHNljZsNqDCGGhwqCqhgDDZV
        hLfRnSLfhcndCCPfJJjzJfzt
        pHNWwDpGGNJBZjjNNj
        gmgwwHpWTpmGDmDTggqHmmDSsnnhvcqScdVVSVcjLrRcnq
        CdlTJgnQJVCllNVWTPZBmPPGhGRmghPRGs
        wHDrSwtHbmhRvHVZ
        DzzwrtVFjLNnMTCTLCWW
        SppdsnGpNVnZZZLPMlMPGq
        mdcfvTTbBddLJgZJLlcFqJ
        fzTvfwjjfzzCbvvjvQjWvNHVNNVWrRtdnVNppNprDp
        lmlCGTmNbZlbSFlbNGfnzWfWzCdWWfVdwRCf
        jDHtHHvLjQtqrsqpjBBLprRzwfwJfzzhRnczhWQVwzVR
        rqpPtpPjDqpqDLtLrPGGFSFgPlNZZSGMPnMZ
        pSHShqgSMzVpphFnJMFMBtssdjRJ
        PZDbZfmCDgDfDNQPwCflCQNJsjRBRBFsdBWBsJRjsbsFJF
        DQvCwwZrPPlffDmQCDwZQPmPhqVTcGhSHSLTpSGhLHzpGghr
        gPqgqqmmmPgsqvGmsMCCnfZZfvBpWZhVrrZdHBvH
        TSlcttTjRTDlDDTRhZVdrHHpWVnfVrtd
        SFJzFzcJjcRJwGGqJMMCwW
        gzWNLSjRLzlNqqQMLhvQccGGmcQm
        fFrttPdTFTrpVwGpbdVQQp
        HnTBGfHTGzWWqCqngn
        SddrLdVpjjVSgRBszFswzwlV
        mtPMbMqPMvqHHHDTTglBvsFshFFg
        bmBHbtPctMtbMNMtbPtPqHmMjpdZdcJGrjSWWZGjJZnjndWj
        nljWJHRHGrDcMBbDLZHV
        wdvwmhghhbtBMcLtwZ
        gvQvvghTfPSmpmQljGFRjQbFGCsJbC
        BmphBWmDBBQfpVgQZpjg
        rqqGrrrqlnqqHqjNnVDSSSgQQffj
        FqLrbsLFsbLbLqHlMrmwwPDcCmMMmJBwDJcC
        wZccfslqZPFFjrFbFfQQ
        vvTvVWCJJZVBWCSvnVJJrhjQVMjVjzbgMQbjpphh
        BBmNWBvZRvSqwsGwssPcmc
        LGpnfcnzfzQdNFNHqHJptq
        RBNNvZSBRbRCCDJqHrDZqHFZtw
        SRNhRsNhWSNWsRRvgjngQnnMTnTgQjGMff
        twtZmwqBHtmqnnmlGLfcfvQQ
        dgMSPSMdQGclRRdF
        pVMrDgThDDlPWPWbBZtZqqttBqjqjT
        PPSWCGSzpCCQwNsNPFhTNVbB
        vqcgJngqLLcZLvBhNTVlbsvdFF
        DDmHgRjHZhHtGfWpQH
        sBLbwWWBvsBsqLqStRjcGGRnggjGcntJDn
        NCMQPMQPMQNzGGRRgRJRGzcG
        dHQNfPCFTQfFfVVNvwwJvSWSqWqrSqdS
        prDBnnDpFDprnDPBDQBvpBZttcSqSZSZcScFJSHcZJtz
        VhMVdLsjdqVWJSWZZZcHst
        hLVdGLfqjGjlfhCfCLjTTmrlpQBPBmvnrgDgpp
        SSSTJmmgbGwtmRZHCCZRCH
        FWcPQrrWqflzSWpRHZCZHRSt
        PSQzzdcQTghdndDJ
        cLlrNPvljRhRgTlM
        VmDBGnVdmJDnDBndnnVwDRvMgRsTbTzMMsgZghzzsB
        SpHvmGnSDJnwvDQqfrCPLpPLCfpF
        PppbRCCgpzzQCgCSgZTlNNTWnNNDNlRnGl
        hwMhLtBcBdjjNzWzlclcNGTs
        FjJFHJwhfwLHMLJLwPmqfQPgVCmQgCmCzC
        jTtMqFjMBqBmTntTztBTnTZBRZRLpLJgDgJNhghJrNNhhLJh
        DCDdvdGsVDVsflVdQSsfSwhRJlgppgpRpbWLgJbJpgbR
        wfSHSsdSVvQSwfwQPQPqHtFDcMzmtjBntqMTqn
        HQhQWLCSHCSCjnjQdSJdCSQgTTmZPTVZmqnTpPtnpmRmpp
        vDrzhvGzfchvlGvMFMrqVqPgZVVtZtVRgZgm
        bcvMfwvDsDfbvfwDbbdhCShWCBLLJWjHsHjj
        zLSsJNCjsjLCNLCgGcwBPPdwBwqwqz
        WMFZprZDbrddWRVRRDvlPPBcPhhlBqqHPGPhhffg
        VdbFvZWWWZZDFTLtCmNntjTnLSnn
        JLVhhwRbhVwcLFJFhhJcccqwsvpRlllvpWvZSBSSSRsNWpzl
        jgzfPffgZNspgZQS
        fjCmDCGnfmTfFqrFnhqbFzqt
        SfMRRNHSNNLfRfHcRRsqwdCCsssTqBCvgBLv
        llDDWQnFGtQnmtGQDWQFsgdHVBddndHsgqTsCTsg
        GzGjpWmWbmQmbpGGmGjHSrZcMfZSRPJPfcMRcb
        PDdMdRTRrLDSwzJvfSvJ
        FnjQnsqsFTnStvplhhzzFS
        TBHHCsgVRRcMHbLR
        GcLdGBJvBvLJHccJBvqHpGzDFfzwfzjwhDwrSFpfpDSn
        mZZrTTQVmQmlsMPVblZQVZmfCwjzzjChzCCbDSzhFjfnSb
        gZlRlZNPlmlgTTPmNRvJWcqrNLdvHWLBcHtH
        jWWbBwgwWwwtvvSCtHvgWsMFmscHzTGMmcssGFTTGz
        ZrLtpLnlfQJqnfJtpLnZlrqdNNGqcDNNFFTNDzzMMTMsMNMs
        LJQrnZnfLZnlrZflJJRVRQbbwBgCtCVjWgjBjjgbPjBB
        fqQVfRqSqmpnlLnm
        jFcjMJTjhwwggjFtgzCHmCzCmGzGlzpn
        wstMFFjWDfQRvmDPSB
        PgTFGPgcBZPcHPFBZRjGPgwCnmwCsmSdQdThmMMMQCQS
        JbpvWtvfHblWDHJDzmndSdMQnSwCdhMdQD
        rfvWlLlbtfJvvLJpqWbbqZRRGPVFNHVFgZNVFBgH
        TRMrrGBLMLPtbssTGtBHwZmdQQbdNzzZZNZZdwjd
        CVlVhCnclvhWSFFfQrWNrjmpNfwmjZ
        rlqFlclChhCvnlDvgVvRRtPtqTGJHRMBRTPPqM
        gZzCrQGQdrQvZHPTHWDbTgWPJM
        nSpLlcnnVjsSVLLnLSnhLSsJPTTWFsqfbPMFMqJDbfqM
        VwwnpwLnlPdQCwPPCC
        lRlrnlrsrMlhVsRnVhGPvCFNcPBDBvccrCGr
        RZQTzWTRdDNvBDdNcC
        TqjZbWRHmlMJgnmsng
        scQmLfQBQQvvZfLsmmvDJwpgSNSDDdcJSSwTGD
        PHlMbtzCCnlbztMRzlPNNdNwGpDpwgwptNLGpw
        rRHnLbhCzbbCHnHjMbzzjzFZmfQqWZQqvmhmfVZmqFBW
        fLTQWTMQtjcCGCJCbf
        gGsmsVSzmjCFHJCJgg
        SPRsSwSvBsPRPsqzwSVqzmhVWtLWhTDNLlTDtLTWGpNMtDLt
        mbzRbchRRQzzssLdhLggLddJ
        DCqDNNNWvDvjcPLsJcLLdv
        cpFCVNnVBHtbfFRtMRFf
        PFRcCCPtsDDDtjVspgwmgTNpTgTpspsw
        BqqqdJdHdMgSfMmZpZND
        vDHJGdLbLzBJdGnDdrBqVtCzWPPhthtPFzzPCFtV
        HvhvHdFdvJDfHdZdpfhrmGPljPRrGPPVDGrWWC
        NMMsRBMzcRRMMBSzcnbmNGrCVCWrCqPClmPqlG
        zLBbwMzQnRSQMThtZFLvpdgHtJfF
        DpcJcJPmMcLSHHZCfpnH
        BsBFvvqTFlbhgdbBBblfZLCLzfHWfjnjLCnCrh
        dTsNgqFvNgsGlZJRtVtMPmtDmG
        LdGQqzPGCCjJTJdTLJQJtFcFRSctcrFNFltPFtcc
        HphMMbbMdBMHbBhhgHMnhvwFFvtrlSNRNgcRllcvcc
        spHMhBnHnnsmWdnsnMBMdVGGmzjzLmZLDQCCCCZjqjTD
        DDZMzcTRgDMLzqCffhfWfcWnfj
        NsHVVJmswwSSwNPPNjnhqhnCCnhNvjfTnv
        rSSddrGSGrlMrpTpQT
        bbbfCfrLHMMMWVWC
        SqsvNZqQvvqcjNvqZsMMwgFgFplTHQVRFgWH
        BSZWWqBZBjmPGJGLbBtf
        RNCNfzfRHmzHwSdRdGfzRJPqFcFcDFGccZZqtLtGLtgl
        pjhVMhvhbjvPcDJvcZqt
        bsQMTsjppmSdTnHSJH
        PtLwpSwdSJwQnGvvqtvMhZ
        TlFcHlTjVjsDTQnCQhbZGCVVnb
        cjljTslTrlzzHDNRfNgLSNBJfBwNfG
        HvsZZqqqwWZswWHTmHsvvfhSfBfDffjchfBbhD
        MCpnCVpQClRNnlNQVQClfDhScmjBfLhmLDGbBNbS
        gmtpJpQQllJnWdZWwJWFwJJT
        TzBvBwwdhgRPGHlRHh
        NLWttJsrLWttppLpsGlsmVbVGRljGDRgjV
        MlllnNFnnQqCdzqq
        vptzrJhMMGGMptJPhJGJPvdFTFcSsTBVsczBScTSFFfn
        gbRjWgRjCqjZnfHCHnTSVBHF
        mRwqNbmqlbbjqRNlLbNrDJntNDGtDhNpGMrpvJ
        GPWZLgWqLHHGbgbbGPPmqHqfcjjRHJJBDRBRjBBjMHjwvwQc
        dhpFSpzVSSMSlDBvMQ
        TndsVNztVTspnsdpshtmZLPCGGNPfgqbWWfDGb
        CbqDjjCdClqgrfJvrv
        NGNPtGGzzHztPWWnlgJvfBnWBFgp
        hGzNHhsmGccwHPHZHcwdCCdbTVRTvSmTCjbLCb
        sqnqsHGpJbqnrbshpshHmmmCWZZmWwfTjTjHmfLZ
        dPggRgSDDttMFgctgdDtDcDcRWJBmjTWwmRLBLfmwBBjZWTB
        PFcVPlJPglbqhhrnnlNz
        wZdDNDdPPfhqwWqbsF
        VTngRzpnzMLvzTCLlhvDfltqqDttqFqs
        mggTVpCDDSNjBmPZrd
        cSdqJSTTTJcSJpCdQbqTCPPdjdDtGzwzjDwjwwwwzD
        rVvsBBVgsVBhHhfljtgbPgGtWjPtwt
        fvHsVZHVnRHpSJJRmbbSLT
        lDDPRRjwLGlvVRDRPlwwwPvmpSfhVWSzhqfzqpHpVpVHfqSH
        qBnqBNsBBChhCSfZ
        nTQbQnNNQJTLvlmTPLqqmG
        TTCJhDrmDpRVhvhHfffwzwfz
        dmmdmglWcqvHvWsHzB
        gdQMZbtlgQlZcMSttCNmVVrLSTTJ
        PLZLqhZZzZLBjjjGrrPjMH
        CcQcCcfRlWDjdrMrBrHC
        WlWFMcFpcRFmsWFcmflqSJzTqzwLvshggsZJwz
        LgqRDDDHHGTpgpJrQrQhhhCqrwPw
        ZSBWjjFshCFlQDrJ
        SjWnnbWtWnsztgGDDbDTGgHHGp
        llfvMlvzjzGzGRfvMSGRfSdStrCtQNCZrrFdJJLnNtLZ
        shhhshPHsTTqsBHTVTwTwZZnCtQrQnJtQCCJBCCZdZ
        TPHTPTHmDnljplfpGfGm
        qcNTmvvSvTNrWhRrTdthzW
        bDVJphpMMJwJpMHtrrttWsgwtzRW
        bFpGJbllPfplVQmnhvvcSmCFqq
        GTPJGMQTPQMqZjHTBmnndBVddHrrzNrz
        bbcRFgDpptRbffwmzmrvLmcZvmLmLv
        WCwgWbpgwtgfpfMlQGPhSPZWTZPl
        DsPCswsMPBMwPDCVJPnTPPWFGJNJmbJW
        RvvddfvftdtvNzghGSbFnWTntJSttGbG
        LNgRddgRlgzcgCDjjjHjcBCwcM
        gnVtgBnpwBgShBgcwhJJhjCMMMDmLRjDRMjrDMMMDMqMRF
        slsblHPNHlbTNbsPvszHQWbzqrZLMRmFMFmdFmrtDFdMLNZD
        bPzfvbfsvvlHtlzPHllHGTlTppCJpgcngcpwnwCGGJnnShwV
        cgQRgtzDbHPcgHzQWpTjTLdjjNNpNLsDss
        nwccZBmwcJqmJnjsTvmlTSsdlTNs
        CCGFCBVrBwwGBhqVnZBrqWMMQzHfQcHzzzPtfztGfg
        lhnwnhlbgbngbcfDgJLJQqDdVd
        FSrvtMFZVJJJVtcq
        jZNNNNjmjSPjFTJmGGzswwzHwHpBsbPblhhW
        tnDWHntzDtzQBZLMLzNLDDcRFFjhJBmcFRCTjRchcRvT
        sqwsPlbGfSbPGSVbJfpjjhcTFmCRjjvmTTvRdw
        lJqSqPVbgGSGrVSqJqflbWZQNDMLHnrQQWNDMtQMQz
        lpltwwJqsWVLPtVt
        DGHsDdZQzHLSLZcFRrFS
        BGsGCnHmMlMwCfwT
        nrRNzRMPrrPnNwNzTSFSTNtqZdtMttvQqQmjdjvZpgjZ
        GWVhGcGhHhGcffbZGDmmtttQvpdtbpppdj
        HGlHBhHGJfJJhCfZzLTTNnNrTnCNwT
        jBpCZStjBwWrQCMrhw
        TvcHBzHdPPzdvFTzzJlvzdQfThrhhrhfQTWMQfWMqfwf
        bzGJJBJcJvdvBPFzddGgjZSbZZngRZNNnnsjRs
        dqPqbpPFJfsFfMcNQNNtNmzrNQJn
        VVBDWvwZWDLwGlDhLGWWVcmQtSNmLmtSdSSTmrcQQm
        lZlhwDCdhhHllvWvjMHbgMpgffMggpPb
        SWSFLLFWDSWDNFzmmLMfGlfsdfnJMBfwMGVnBf
        vPtgZcctcTQQZRRcgCtZwRfqBVGqnVTBGVnqlsdBJnqV
        RcjgwbbgNSbFbhDb
        JrRZLrHvjQFPLnnBPQ
        DhwbtHbzpcpFTgtQ
        zlDwlHlzWSwDqhMMbSJVZVvrCrCZJZNZdJ
        fgNCZSDtDfDZTrTfqWghQGzGQshgpGGFQg
        RFvLnvFjnVjmLQGPQWLmWh
        MdwwVMFbMdRHFbccbCZJtbDJrqqJZNJZCZ
        fdZVBMMdfdfBCzhTzMdMCgCrGGrpQJmSmGJGmpJQVpLmqV
        RbFnhNsvlDsFHttllGmqGpPLvJpmPJSqLL
        tjNsDnNwbNjttNNZTzhMWzcZcMTwMd
        DjSSMShjRjPCbDFCdCSDbpBBswfNWZBZZrBVBPNfVmVf
        zltLjLqqGlzQntqqGztqcgncZrVrmNfNwWBVrVmrgwrfswsW
        qcTqHLlnJzGznLJtHGhMbhjFhMMpFbpbThpp
        ZVFZcctFQzsCtbZFnPPHqmqpwmvPmp
        NrjGfMgcLLcfdLqpmRwRRqJJmdPw
        LMNDgMBGlgGDLMNDGljctVbVWZTTCWChhTttsl
        RMGRRhhgzgZMtHdGTtvDwDJFCDvvwdvwqFFv
        rfrrjLNmmSnSjVSmNNPPbJVbqvqsqvhvFqCq
        flrpnSlrSNfjrNjSphNSWlHRGzTgtQGHQtttBTRBRQHW
        tplDDprhbvprvrJDprCpbsvHRfzSzTtzmRqSTznRRBRnSfFF
        MVwWjVNVQGfcMnTmRnBm
        VQwGLNLjWNWPGjZbsDBppBZhhDvBlZ
        RVVrGVVchRZsnzRzBWZb
        FQHWWCHwQmWmlqfCHSwJnsbNJnNsvttntBtb
        QQSFgqgqLMLPPdWdMVhWDT
        cZrMjncTdfJpPJbr
        WHNqnQwwCwvlqHtCtHNslNlvLLPDfSVdVPVDVSfVSbftffVf
        NCwwwQwllwnvgsvZzgzFZzBzjGGGMM
        MvHpfzcTcZzpphhbsDSTStsltqSDtS
        PRmnwCrWnWQrmNMRNnlNGbqlbDltdlbDtNtD
        CRJnmRVWJfgMLvcz
        HPFbHrrwLdVdgbDZqcphCqSZBhLZ
        tQRfRRGtvTNNSGTMjjmDCRhmqpBChqhsRDZh
        vjSfMzGQNQQnMtNTTWNNjgblFdFHwgdJJHHPwddgnr
        BggPRVBPPgfCBmJTjTTqpTNpZBwMbr
        lclLLllsQLFlsbMqNrMwTpwpcM
        SvbDzSDbWFJfWPPgdnfR
        GbpSSbGDNbSSJbDZNZbDppGtMntHLHvHCTLCJMHnRCMLTT
        cdwddjBfPsmPPQqQqscnHgRMtngvtjjgCCTMzM
        WvwPvWvflBwdQPlNVVhbDGpFhNGhbl
        WZRGmRvpCRFTZMQQQMCdddDDcD
        lqgqsgvjVtbMDzzbtcDQ
        NsNNgjNNjsNhnSvRmnpGRmSTSG
        nTgFtDTDDLrFBStdGdcHcbvGSc
        QPzfPCMzWCjfMPJhWGlRbRWRWrRRdVVH
        zhCrCQCjPrpNNBsNspNnwq
        zTJpqFzbTzsWsVbbfLGfSSCDNSBCHfMLHG
        rZcvtmhctrvmlPPmmmrhhmBLCHDCCLLDlqMlGMNDMwDC
        rRhRhnnQPZhtZcZtdttZgqFWWVjssqQpppWpFpJW
        NWPhdWJPWVzVqQrqmSsPbrPP
        cZDRjGsffGsCDfffgjGgRQSrTcTmSlTrbnqmSSrlln
        fFGCjGCjLDLFRgfDHZvzLVWtvsWWBtzJNWMB
        qMVbtnmMMTpCppsR
        NffHGrWzWWgDBfTRhChCnSCWcnjT
        QrlQBPBrlPHrrQlrHFLqPnLvVvbVmVVJtq
        MVMpHMZLVCpMrfWjvWnfrJ
        hlblzDDzwlSlGtRhRlSdrfGGWnWWfFPjJjnfqWGF
        lmlhBRlDhhhDRRhwDmBpHJmsNCHmCgNHJCJLsc
        jvsLgmqLgHvbPPVbNjSCjC
        pwTcRpRWLRMLJJFwBBGWcFWNVlDDCSTVttNPblZZCVVDlP
        GcdhccpcpRpGRhGmfsHHzLQQHrmsnh
        FMmSRgtMltMnVgnmNvlrsJrsZWjspvsZJp
        QbdhqwqbNqdHbTdcbcpsrpvjfWfLJLfwJrWp
        DQBBQqQGccdTPGqqBNtFGRSMRSFGtnVSnnmM
        fPjGrfFrrprprdrbQPZwlcZwZmlJwH
        qvNnvWnvWDvSvqNtWSLWStqbcJBQwQJwQZHLBZbcmJbblb
        DMtvqSvvDtntCRfwzGCgdzzFjG
        TfdZgtmfDgqgvlLFFsFHvcvZ
        pphWQMVjQVVBWWjRlHlHnlcLDDhcnF
        JQwwWVPBwMJpJwpWwGBWNzrDzSSzfgTPqTSTTtSPgt
        """;
  }
}
