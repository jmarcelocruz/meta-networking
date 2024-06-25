DESCRIPTION = "SystemD service unit for dnsmasq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://dnsmasq.service;endline=13;md5=27be7bfeb5e6edda0e7bb364c241a18a"

SRC_URI = "file://dnsmasq.service"

S = "${WORKDIR}"

inherit allarch features_check systemd

REQUIRED_DISTRO_FEATURES = "systemd"
SYSTEMD_SERVICE:${PN} = "dnsmasq.service"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install ${S}/dnsmasq.service ${D}${systemd_unitdir}/system/dnsmasq.service
}

RDEPENDS:${PN} = "dnsmasq"
